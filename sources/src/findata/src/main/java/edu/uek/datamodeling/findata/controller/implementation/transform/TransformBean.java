package edu.uek.datamodeling.findata.controller.implementation.transform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import edu.uek.datamodeling.findata.controller.implementation.enums.ResponseStatus;
import edu.uek.datamodeling.findata.controller.implementation.transform.request.TransformRequest;
import edu.uek.datamodeling.findata.controller.implementation.transform.response.TransformResponse;
import edu.uek.datamodeling.findata.controller.service.TransformService;
import edu.uek.datamodeling.findata.model.db.entity.Company;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;
import edu.uek.datamodeling.findata.model.db.entity.Stock;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataCompanyExchangeModel;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataExchangeEntityModel;


// TODO: Auto-generated Javadoc
/**
 * The Class TransformBean.
 */
@Service("transformService")
public class TransformBean implements TransformService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6316919239059940520L;
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(TransformBean.class);

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.controller.service.TransformService#doTransform(edu.uek.datamodeling.findata.controller.implementation.transform.request.TransformRequest)
	 */
	public TransformResponse doTransform(TransformRequest request) {
		
		TransformResponse response = new TransformResponse();
		
		if (request.getFindataEntitiesToTransform() == null || request.getFindataEntitiesToTransform().isEmpty() == true) {
			log.error(String.format("Request parameters resolved to null or empty!"));
			response.setStatus(ResponseStatus.ERROR);
			response.setDesc("Parameters problem!");
			return response;
		}
		
		log.info(String.format("*********************************************************************************"));
		log.info(String.format("****     TRANSFORM  SERVICE     *************************************************"));
		log.info(String.format("*********************************************************************************"));
		
		/*
		 * Date transforming
		 * All entities stored in list given in request parameter have the same date.
		 * Taking date from the first entry.
		 * */
		String dateToTransform = request.getFindataEntitiesToTransform().get(0).getDate();
		Date date = null;
		try {
			log.info(String.format("Trying to convert date..."));
			date = new SimpleDateFormat("EEEE, d MMMM yyyy", Locale.ENGLISH).parse(dateToTransform);
			log.info(String.format("Date successfully converted"));
		} catch (ParseException e) {
			log.error(String.format("Unable to convert date %s: %s", dateToTransform, e.getCause()));
		}
		
		log.info(String.format("Attempting to tranform given Findata Entities into DB entities..."));
		
		List<Stock> stockList = new ArrayList<Stock>();
		List<Company> companyList = new ArrayList<Company>();
		List<Exchange> exchangeList = new ArrayList<Exchange>();
		
		for (FindataExchangeEntityModel findataModel : request.getFindataEntitiesToTransform()) {
			
			// Stock transform
			Stock stock = new Stock();
			stock.setCode(findataModel.getStockCode());
			stock.setFullName(findataModel.getStockName());
			stockList.add(stock);
			
			for (FindataCompanyExchangeModel companyModel : findataModel.getCompanyExchangeModelList()) {
				
				// Company tranform
				Company company = new Company();
				company.setStock(stock);
				company.setCode(companyModel.getCode());
				company.setFullName(companyModel.getName());
				companyList.add(company);
				
				// Exchange transform
				Exchange exchange = new Exchange();
				if (date != null) {
					exchange.setDate(date);
				}
				exchange.setHighestValue(Float.parseFloat(companyModel.getHigh().replace(",", ".")));
				exchange.setLowestValue(Float.parseFloat(companyModel.getLow().replace(",", ".")));
				exchange.setClosingValue(Float.parseFloat(companyModel.getClose().replace(",", ".")));
				exchange.setVolumeValue(Float.parseFloat(companyModel.getVolume().replaceAll(",", "")));
				exchange.setChangeValue(Float.parseFloat(companyModel.getChange().replace(",", ".")));
				exchange.setCompany(company);
				exchangeList.add(exchange);
			}
		}
		
		response.setStockList(stockList);
		response.setCompanyList(companyList);
		response.setExchangeList(exchangeList);
		
		log.info(String.format("Successfully tranformed Findata Entities into DB Entities!"));
		
		response.setStatus(ResponseStatus.SUCCESS);

		return response;
		
	}

}
