package edu.uek.datamodeling.findata.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.uek.datamodeling.findata.model.db.entity.Company;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;
import edu.uek.datamodeling.findata.model.db.entity.Stock;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataExchangeEntityModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ViewModel.
 */
@Component("viewModel")
@Scope("session")
public class ViewModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 646274638581157934L;

	/** The stock codes. */
	private final List<String> STOCK_CODES = Arrays.asList("AMEX", "NYSE", "NASDAQ");
	
	/** The symbols. */
	private final List<String> SYMBOLS = Arrays.asList("A", "B", "C");

	/** The process method. */
	private String processMethod;
	
	/** The results panel rendered. */
	private boolean resultsPanelRendered;

	/** The selected stock. */
	private String selectedStock;
	
	/** The selected symbol. */
	private String selectedSymbol;

	/** The findata entity model list. */
	private List<FindataExchangeEntityModel> findataEntityModelList;

	/** The extract panel rendered. */
	private boolean extractPanelRendered;

	/** The transformed stock list. */
	private List<Stock> transformedStockList;
	
	/** The transformed company list. */
	private List<Company> transformedCompanyList;
	
	/** The transformed exchange list. */
	private List<Exchange> transformedExchangeList;

	/** The transform panel rendered. */
	private boolean transformPanelRendered;
	
	/** The updated stock list. */
	private List<Stock> updatedStockList;
	
	/** The updated company list. */
	private List<Company> updatedCompanyList;
	
	/** The exchange list. */
	private List<Exchange> exchangeList;
	
	/** The load panel rendered. */
	private boolean loadPanelRendered;
	
	/** The new stocks table rendered. */
	private boolean newStocksTableRendered;
	
	/** The new companies table rendered. */
	private boolean newCompaniesTableRendered;

	
	/**
	 * Gets the process method.
	 *
	 * @return the process method
	 */
	public String getProcessMethod() {
		return processMethod;
	}
	
	/**
	 * Sets the process method.
	 *
	 * @param processMethod the new process method
	 */
	public void setProcessMethod(String processMethod) {
		this.processMethod = processMethod;
	}

	/**
	 * Gets the findata entity model list.
	 *
	 * @return the findata entity model list
	 */
	public List<FindataExchangeEntityModel> getFindataEntityModelList() {
		return findataEntityModelList;
	}

	/**
	 * Sets the findata entity model list.
	 *
	 * @param findataEntityModelList the new findata entity model list
	 */
	public void setFindataEntityModelList(
			List<FindataExchangeEntityModel> findataEntityModelList) {
		this.findataEntityModelList = findataEntityModelList;
	}

	/**
	 * Gets the stock codes.
	 *
	 * @return the stock codes
	 */
	public List<String> getStockCodes() {
		return STOCK_CODES;
	}

	/**
	 * Gets the symbols.
	 *
	 * @return the symbols
	 */
	public List<String> getSymbols() {
		return SYMBOLS;
	}

	/**
	 * Gets the selected stock.
	 *
	 * @return the selected stock
	 */
	public String getSelectedStock() {
		return selectedStock;
	}

	/**
	 * Sets the selected stock.
	 *
	 * @param selectedStock the new selected stock
	 */
	public void setSelectedStock(String selectedStock) {
		this.selectedStock = selectedStock;
	}

	/**
	 * Gets the selected symbol.
	 *
	 * @return the selected symbol
	 */
	public String getSelectedSymbol() {
		return selectedSymbol;
	}

	/**
	 * Sets the selected symbol.
	 *
	 * @param selectedSymbol the new selected symbol
	 */
	public void setSelectedSymbol(String selectedSymbol) {
		this.selectedSymbol = selectedSymbol;
	}

	/**
	 * Checks if is extract panel rendered.
	 *
	 * @return true, if is extract panel rendered
	 */
	public boolean isExtractPanelRendered() {
		return extractPanelRendered;
	}
	
	/**
	 * Sets the extract panel rendered.
	 *
	 * @param extractPanelRendered the new extract panel rendered
	 */
	public void setExtractPanelRendered(boolean extractPanelRendered) {
		this.extractPanelRendered = extractPanelRendered;
	}

	/**
	 * Checks if is transform panel rendered.
	 *
	 * @return true, if is transform panel rendered
	 */
	public boolean isTransformPanelRendered() {
		return transformPanelRendered;
	}

	/**
	 * Sets the transform panel rendered.
	 *
	 * @param transformPanelRendered the new transform panel rendered
	 */
	public void setTransformPanelRendered(boolean transformPanelRendered) {
		this.transformPanelRendered = transformPanelRendered;
	}

	/**
	 * Checks if is load panel rendered.
	 *
	 * @return true, if is load panel rendered
	 */
	public boolean isLoadPanelRendered() {
		return loadPanelRendered;
	}

	/**
	 * Sets the load panel rendered.
	 *
	 * @param loadPanelRendered the new load panel rendered
	 */
	public void setLoadPanelRendered(boolean loadPanelRendered) {
		this.loadPanelRendered = loadPanelRendered;
	}

	/**
	 * Gets the transformed stock list.
	 *
	 * @return the transformed stock list
	 */
	public List<Stock> getTransformedStockList() {
		return transformedStockList;
	}

	/**
	 * Sets the transformed stock list.
	 *
	 * @param transformedStockList the new transformed stock list
	 */
	public void setTransformedStockList(List<Stock> transformedStockList) {
		this.transformedStockList = transformedStockList;
	}

	/**
	 * Gets the transformed company list.
	 *
	 * @return the transformed company list
	 */
	public List<Company> getTransformedCompanyList() {
		return transformedCompanyList;
	}

	/**
	 * Sets the transformed company list.
	 *
	 * @param transformedCompanyList the new transformed company list
	 */
	public void setTransformedCompanyList(List<Company> transformedCompanyList) {
		this.transformedCompanyList = transformedCompanyList;
	}

	/**
	 * Gets the transformed exchange list.
	 *
	 * @return the transformed exchange list
	 */
	public List<Exchange> getTransformedExchangeList() {
		return transformedExchangeList;
	}

	/**
	 * Sets the transformed exchange list.
	 *
	 * @param transformedExchangeList the new transformed exchange list
	 */
	public void setTransformedExchangeList(
			List<Exchange> transformedExchangeList) {
		this.transformedExchangeList = transformedExchangeList;
	}

	/**
	 * Gets the updated stock list.
	 *
	 * @return the updated stock list
	 */
	public List<Stock> getUpdatedStockList() {
		return updatedStockList;
	}

	/**
	 * Sets the updated stock list.
	 *
	 * @param updatedStockList the new updated stock list
	 */
	public void setUpdatedStockList(List<Stock> updatedStockList) {
		this.updatedStockList = updatedStockList;
	}

	/**
	 * Gets the updated company list.
	 *
	 * @return the updated company list
	 */
	public List<Company> getUpdatedCompanyList() {
		return updatedCompanyList;
	}

	/**
	 * Sets the updated company list.
	 *
	 * @param updatedCompanyList the new updated company list
	 */
	public void setUpdatedCompanyList(List<Company> updatedCompanyList) {
		this.updatedCompanyList = updatedCompanyList;
	}

	/**
	 * Checks if is new stocks table rendered.
	 *
	 * @return true, if is new stocks table rendered
	 */
	public boolean isNewStocksTableRendered() {
		return newStocksTableRendered;
	}
	
	/**
	 * Sets the new stocks table rendered.
	 *
	 * @param newStocksTableRendered the new new stocks table rendered
	 */
	public void setNewStocksTableRendered(boolean newStocksTableRendered) {
		this.newStocksTableRendered = newStocksTableRendered;
	}

	/**
	 * Checks if is new companies table rendered.
	 *
	 * @return true, if is new companies table rendered
	 */
	public boolean isNewCompaniesTableRendered() {
		return newCompaniesTableRendered;
	}

	/**
	 * Sets the new companies table rendered.
	 *
	 * @param newCompaniesTableRendered the new new companies table rendered
	 */
	public void setNewCompaniesTableRendered(boolean newCompaniesTableRendered) {
		this.newCompaniesTableRendered = newCompaniesTableRendered;
	}

	/**
	 * Gets the exchange list.
	 *
	 * @return the exchange list
	 */
	public List<Exchange> getExchangeList() {
		return exchangeList;
	}

	/**
	 * Sets the exchange list.
	 *
	 * @param exchangeList the new exchange list
	 */
	public void setExchangeList(List<Exchange> exchangeList) {
		this.exchangeList = exchangeList;
	}

	/**
	 * Checks if is results panel rendered.
	 *
	 * @return true, if is results panel rendered
	 */
	public boolean isResultsPanelRendered() {
		return resultsPanelRendered;
	}

	/**
	 * Sets the results panel rendered.
	 *
	 * @param resultsPanelRendered the new results panel rendered
	 */
	public void setResultsPanelRendered(boolean resultsPanelRendered) {
		this.resultsPanelRendered = resultsPanelRendered;
	}

}
