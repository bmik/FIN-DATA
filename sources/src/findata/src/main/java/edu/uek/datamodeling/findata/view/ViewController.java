package edu.uek.datamodeling.findata.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.uek.datamodeling.findata.controller.implementation.enums.ResponseStatus;
import edu.uek.datamodeling.findata.controller.implementation.extract.request.ExtractRequest;
import edu.uek.datamodeling.findata.controller.implementation.extract.response.ExtractResponse;
import edu.uek.datamodeling.findata.controller.implementation.load.request.LoadRequest;
import edu.uek.datamodeling.findata.controller.implementation.load.response.LoadResponse;
import edu.uek.datamodeling.findata.controller.implementation.transform.request.TransformRequest;
import edu.uek.datamodeling.findata.controller.implementation.transform.response.TransformResponse;
import edu.uek.datamodeling.findata.controller.service.ExtractService;
import edu.uek.datamodeling.findata.controller.service.LoadService;
import edu.uek.datamodeling.findata.controller.service.TransformService;
import edu.uek.datamodeling.findata.model.db.entity.Company;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;
import edu.uek.datamodeling.findata.model.db.entity.Stock;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataCompanyExchangeModel;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataExchangeEntityModel;

// TODO: Auto-generated Javadoc
/**
 * Kontroler widoku. Składa się z metod ktore wywołują akcje dla poszczegolnych przyciskow na stronie index.xhtml.
 *
 */
@Controller("viewController")
@Scope("prototype")
public class ViewController implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5317413022036931996L;
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(ViewController.class);

	/**
	 * Wstrzyknięty obiekt usługi "Extract" z modułu "Controller".
	 */
	@Autowired
	private ExtractService extractService;
	/**
	 * Wstrzyknięty obiekt usługi "Transform" z modułu "Controller".
	 */
	@Autowired
	private TransformService transformService;
	/**
	 * Wstrzyknięty obiekt usługi "Load" z moduły "Controller".
	 */
	@Autowired
	private LoadService loadService;
	
	/**
	 * Wstrzyknięty obiekt będący modelem widoku.
	 */
	@Autowired
	private ViewModel model;
	
	/**
	 * Metoda, ktora wywoluje wszystkie usługi procesow ETL w porządanej kolejności.
	 */
	public void doETL() {
		
		log.info(String.format("Preparing to extract..."));
		
		ExtractRequest extractRequest = new ExtractRequest(model.getStockCodes(), model.getSymbols());
		ExtractResponse extractResponse = extractService.doExtract(extractRequest);
		
		List<FindataExchangeEntityModel> findataExchangeEntityModelList = new ArrayList<FindataExchangeEntityModel>();
		
		if (ResponseStatus.SUCCESS.equals(extractResponse.getStatus())) {
			findataExchangeEntityModelList = extractResponse.getFindataExchangeEntityModelList();
			log.info(String.format("Successfully extracted findata entities"));
		} else {
			log.error(String.format("Unable to extract findata entities"));
			// TODO faces message
			return;
		}
		
		log.info(String.format("Preparing to transform..."));
		
		TransformRequest transformRequest = new TransformRequest(findataExchangeEntityModelList);
		TransformResponse transformResponse = transformService.doTransform(transformRequest);
		
		List<Stock> transformedStockList = new ArrayList<Stock>();
		List<Company> transformedCompanyList = new ArrayList<Company>();
		List<Exchange> transformedExchangeList = new ArrayList<Exchange>();
		
		if (ResponseStatus.SUCCESS.equals(transformResponse.getStatus())) {
			transformedStockList = transformResponse.getStockList();
			transformedCompanyList = transformResponse.getCompanyList();
			transformedExchangeList = transformResponse.getExchangeList();
			log.info("Successfully transformed findata entites into DB entities");
		} else {
			log.error(String.format("Unable to transform findata entities into DB entities"));
			// TODO faces message
			return;
		}
		
		log.info(String.format("Preparing to load..."));
		
		LoadRequest loadRequest = new LoadRequest();
		loadRequest.setStockListToLoad(transformedStockList);
		loadRequest.setCompanyListToLoad(transformedCompanyList);
		loadRequest.setExchangeListToLoad(transformedExchangeList);
		LoadResponse loadResponse = loadService.doLoad(loadRequest);
		
		if (ResponseStatus.SUCCESS.equals(loadResponse.getStatus())) {
			model.setUpdatedStockList(loadResponse.getUpdatedStockList());
			model.setUpdatedCompanyList(loadResponse.getUpdatedCompanyList());
			model.setExchangeList(loadResponse.getExchangeList());
			
			log.info(String.format("Successfully loaded data into DB"));
		} else {
			log.error(String.format("Unable to load data into DB"));
			// TODO faces message
			return;
		}
		
		model.setResultsPanelRendered(true);
		
	}

	/**
	 * Metoda, ktora wywołuje usługę "Extract" i ustawia zwrocone wartości w modelu widoku.
	 */
	public void extract() {
		
		log.info(String.format("Preparing to extract..."));
		
		ExtractRequest request = new ExtractRequest(model.getStockCodes(), model.getSymbols());
		ExtractResponse response = extractService.doExtract(request);
		
		if (ResponseStatus.SUCCESS.equals(response.getStatus())) {
			model.setFindataEntityModelList(response.getFindataExchangeEntityModelList());
			
			model.setExtractPanelRendered(true);
			model.setTransformPanelRendered(false);
			model.setLoadPanelRendered(false);
			
			log.info(String.format("Successfully extracted findata entities"));
		} else {
			log.error(String.format("Unable to extract findata entities"));
			// TODO faces message
		}
		
	}
	
	/**
	 * Metoda, ktora wywołuje usługę "Transform" i ustawia zwrocone wartości w modelu widoku.
	 */
	public void transform() {
		
		log.info(String.format("Preparing to transform..."));
		
		TransformRequest request = new TransformRequest(model.getFindataEntityModelList());
		TransformResponse response = transformService.doTransform(request);
		
		if (ResponseStatus.SUCCESS.equals(response.getStatus())) {
			model.setTransformedStockList(response.getStockList());
			model.setTransformedCompanyList(response.getCompanyList());
			model.setTransformedExchangeList(response.getExchangeList());
			
			model.setExtractPanelRendered(false);
			model.setTransformPanelRendered(true);
			model.setLoadPanelRendered(false);
			
			log.info("Successfully transformed findata entites into DB entities");
		} else {
			log.error(String.format("Unable to transform findata entities into DB entities"));
			// TODO faces message
		}
		
	}
	
	/**
	 * Metoda, ktora wywołuje usługę "Load" i ustawia zwrocone wartości w modelu widoku.
	 */
	public void load() {
		
		log.info(String.format("Preparing to load..."));
		
		LoadRequest request = new LoadRequest();
		request.setStockListToLoad(model.getTransformedStockList());
		request.setCompanyListToLoad(model.getTransformedCompanyList());
		request.setExchangeListToLoad(model.getTransformedExchangeList());
		LoadResponse response = loadService.doLoad(request);
		
		if (ResponseStatus.SUCCESS.equals(response.getStatus())) {
			model.setUpdatedStockList(response.getUpdatedStockList());
			model.setUpdatedCompanyList(response.getUpdatedCompanyList());
			model.setExchangeList(response.getExchangeList());
			
			model.setExtractPanelRendered(false);
			model.setTransformPanelRendered(false);
			model.setLoadPanelRendered(true);
			
			log.info(String.format("Successfully loaded data into DB"));
		} else {
			log.error(String.format("Unable to load data into DB"));
			// TODO faces message
		}
		
	}
	
	/**
	 * Metoda, ktora zwraca liste encji z kroku "Extract" w zależności od wybranej giełdy oraz pierwszej litery spolki.
	 *
	 * @param stockCode the stock code
	 * @param symbol the symbol
	 * @return the companies exchanges list
	 */
	public List<FindataCompanyExchangeModel> getCompaniesExchangesList(String stockCode, String symbol) {
		
		for (FindataExchangeEntityModel stock : model.getFindataEntityModelList()) {
			if (stockCode.equals(stock.getStockCode())) {
				List<FindataCompanyExchangeModel> modelList = new ArrayList<FindataCompanyExchangeModel>();
				for (FindataCompanyExchangeModel company : stock.getCompanyExchangeModelList()) {
					if (symbol.equals(company.getSymbol())) {
						modelList.add(company);
					}
				}
				return modelList;
			}
		}
		
		return null;
	}
	
	/**
	 * Metoda, ktora zwraca pełną nazwę giełdy na podstawie podanego kodu.
	 *
	 * @param stockCode the stock code
	 * @return the stock full name
	 */
	public String getStockFullName(String stockCode) {
		for (FindataExchangeEntityModel stock : model.getFindataEntityModelList()) {
			if (stockCode.equals(stock.getStockCode())) {
				return stock.getStockName();
			}
		}
		return null;
	}
	
	/**
	 * Metoda, ktora zwraca Datę uzyskaną w procesie "Extract".
	 *
	 * @return the date
	 */
	public String getDate() {
		if (model.getFindataEntityModelList() != null) {
			return model.getFindataEntityModelList().get(0).getDate();
		}
		return null;
	}
	
	
	/**
	 * *********************
	 * METODY POMOCNICZE
	 * *********************.
	 *
	 * @param isRendered the new new stocks table rendered
	 */
	
	public void setNewStocksTableRendered(boolean isRendered) {
		model.setNewStocksTableRendered(isRendered);
	}
	
	/**
	 * Sets the new companies table rendered.
	 *
	 * @param isRendered the new new companies table rendered
	 */
	public void setNewCompaniesTableRendered(boolean isRendered) {
		model.setNewCompaniesTableRendered(isRendered);
	}
	
	/**
	 * Reset.
	 */
	public void reset() {
		String processMethod = model.getProcessMethod();
		model = new ViewModel();
		model.setProcessMethod(processMethod);
	}
	
	
}
