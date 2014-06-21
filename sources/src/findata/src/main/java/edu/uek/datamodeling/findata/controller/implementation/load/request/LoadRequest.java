package edu.uek.datamodeling.findata.controller.implementation.load.request;

import java.io.Serializable;
import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Company;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;
import edu.uek.datamodeling.findata.model.db.entity.Stock;

// TODO: Auto-generated Javadoc
/**
 * The Class LoadRequest.
 */
public class LoadRequest implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7369111738983465987L;
	
	/** The stock list to load. */
	private List<Stock> stockListToLoad;
	
	/** The company list to load. */
	private List<Company> companyListToLoad;
	
	/** The exchange list to load. */
	private List<Exchange> exchangeListToLoad;
	
	/**
	 * Gets the stock list to load.
	 *
	 * @return the stock list to load
	 */
	public List<Stock> getStockListToLoad() {
		return stockListToLoad;
	}
	
	/**
	 * Sets the stock list to load.
	 *
	 * @param stockListToLoad the new stock list to load
	 */
	public void setStockListToLoad(List<Stock> stockListToLoad) {
		this.stockListToLoad = stockListToLoad;
	}
	
	/**
	 * Gets the company list to load.
	 *
	 * @return the company list to load
	 */
	public List<Company> getCompanyListToLoad() {
		return companyListToLoad;
	}
	
	/**
	 * Sets the company list to load.
	 *
	 * @param companyListToLoad the new company list to load
	 */
	public void setCompanyListToLoad(List<Company> companyListToLoad) {
		this.companyListToLoad = companyListToLoad;
	}
	
	/**
	 * Gets the exchange list to load.
	 *
	 * @return the exchange list to load
	 */
	public List<Exchange> getExchangeListToLoad() {
		return exchangeListToLoad;
	}
	
	/**
	 * Sets the exchange list to load.
	 *
	 * @param exchangeListToLoad the new exchange list to load
	 */
	public void setExchangeListToLoad(List<Exchange> exchangeListToLoad) {
		this.exchangeListToLoad = exchangeListToLoad;
	}

}
