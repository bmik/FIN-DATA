package edu.uek.datamodeling.findata.controller.implementation.transform.response;

import java.io.Serializable;
import java.util.List;

import edu.uek.datamodeling.findata.controller.implementation.Response;
import edu.uek.datamodeling.findata.model.db.entity.Company;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;
import edu.uek.datamodeling.findata.model.db.entity.Stock;

// TODO: Auto-generated Javadoc
/**
 * The Class TransformResponse.
 */
public class TransformResponse extends Response implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2776769234838965350L;

	/** The stock list. */
	private List<Stock> stockList;
	
	/** The company list. */
	private List<Company> companyList;
	
	/** The exchange list. */
	private List<Exchange> exchangeList;
	
	
	
	/**
	 * Gets the stock list.
	 *
	 * @return the stock list
	 */
	public List<Stock> getStockList() {
		return stockList;
	}
	
	/**
	 * Sets the stock list.
	 *
	 * @param stockList the new stock list
	 */
	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}
	
	/**
	 * Gets the company list.
	 *
	 * @return the company list
	 */
	public List<Company> getCompanyList() {
		return companyList;
	}
	
	/**
	 * Sets the company list.
	 *
	 * @param companyList the new company list
	 */
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
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
	
}
