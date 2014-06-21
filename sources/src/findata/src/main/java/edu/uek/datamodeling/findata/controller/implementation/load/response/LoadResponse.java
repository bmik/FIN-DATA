package edu.uek.datamodeling.findata.controller.implementation.load.response;

import java.io.Serializable;
import java.util.List;

import edu.uek.datamodeling.findata.controller.implementation.Response;
import edu.uek.datamodeling.findata.model.db.entity.Company;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;
import edu.uek.datamodeling.findata.model.db.entity.Stock;

// TODO: Auto-generated Javadoc
/**
 * The Class LoadResponse.
 */
public class LoadResponse extends Response implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 124700724331830448L;

	/** The updated stock list. */
	private List<Stock> updatedStockList;
	
	/** The updated company list. */
	private List<Company> updatedCompanyList;
	
	/** The exchange list. */
	private List<Exchange> exchangeList;

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
