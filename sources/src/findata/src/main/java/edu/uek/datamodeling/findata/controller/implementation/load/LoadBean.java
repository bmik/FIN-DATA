package edu.uek.datamodeling.findata.controller.implementation.load;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uek.datamodeling.findata.controller.implementation.enums.ResponseStatus;
import edu.uek.datamodeling.findata.controller.implementation.load.request.LoadRequest;
import edu.uek.datamodeling.findata.controller.implementation.load.response.LoadResponse;
import edu.uek.datamodeling.findata.controller.service.LoadService;
import edu.uek.datamodeling.findata.model.db.dao.CompanyDAO;
import edu.uek.datamodeling.findata.model.db.dao.ExchangeDAO;
import edu.uek.datamodeling.findata.model.db.dao.StockDAO;
import edu.uek.datamodeling.findata.model.db.entity.Company;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;
import edu.uek.datamodeling.findata.model.db.entity.Stock;

// TODO: Auto-generated Javadoc
/**
 * The Class LoadBean.
 */
@Service("loadService")
public class LoadBean implements LoadService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9086924963898459133L;

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(LoadService.class);
	
	/** The stock dao. */
	@Autowired
	private StockDAO stockDao;
	
	/** The company dao. */
	@Autowired
	private CompanyDAO companyDao;
	
	/** The exchange dao. */
	@Autowired
	private ExchangeDAO exchangeDao;

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.controller.service.LoadService#doLoad(edu.uek.datamodeling.findata.controller.implementation.load.request.LoadRequest)
	 */
	@Override
	public LoadResponse doLoad(LoadRequest request) {

		LoadResponse response = new LoadResponse();
		
		if (request.getCompanyListToLoad() == null || request.getCompanyListToLoad().isEmpty() == true ||
				request.getExchangeListToLoad() == null || request.getExchangeListToLoad().isEmpty() == true || 
				request.getStockListToLoad() == null || request.getStockListToLoad().isEmpty() == true) {
			log.error(String.format("Request parameters resolved to null or empty!"));
			response.setStatus(ResponseStatus.ERROR);
			response.setDesc("Parameters problem!");
			return response;
		}
		
		log.info(String.format("*********************************************************************************"));
		log.info(String.format("****     LOAD  SERVICE     ******************************************************"));
		log.info(String.format("*********************************************************************************"));
		
		// Update stock list
		log.info(String.format("Attempting to add new stock entites..."));
		List<Stock> createdStockList = new ArrayList<Stock>();
 		for (Stock stock : request.getStockListToLoad()) {
			// Check if stock with code exists
			if (stockDao.getStockByCode(stock.getCode()) == null) {
				stockDao.createStock(stock);
				createdStockList.add(stock);
			}
		}
 		
 		log.info(String.format("Successfully added new stock entities into DB"));
 		
 		// Update company list
 		log.info(String.format("Attempting to add new company entites..."));
 		List<Company> createdCompanyList = new ArrayList<Company>();
 		for (Company company : request.getCompanyListToLoad()) {
 			// Check if company with code exists 
 			if (companyDao.getCompanyByCode(company.getCode()) == null) {
 				Stock relationStock = stockDao.getStockByCode(company.getStock().getCode());
 				company.setStock(relationStock);
 				companyDao.createCompany(company);
 				createdCompanyList.add(company);
 			}
 		}
 		
 		log.info(String.format("Successfully added new company entities into DB"));
 		
 		// Add new exchanges 
 		log.info(String.format("Attempting to add new exchange entites..."));
 		for (Exchange exchange : request.getExchangeListToLoad())  {
 			// Check if entry exists entry for actual date
 			if (exchangeDao.getExchangeByDateAndCompany(exchange.getDate(), exchange.getCompany().getCode()) == null) {
 				Company relationCompany = companyDao.getCompanyByCode(exchange.getCompany().getCode());
 				exchange.setCompany(relationCompany);
 				exchangeDao.createExchange(exchange);
 			}
 		}
 		
 		log.info(String.format("Successfully added new exchange entities into DB"));
 		
 		response.setUpdatedCompanyList(createdCompanyList);
 		response.setUpdatedStockList(createdStockList);
 		response.setExchangeList(exchangeDao.getAllExchanges());
		
 		response.setStatus(ResponseStatus.SUCCESS);
 		
		return response;
	}

}
