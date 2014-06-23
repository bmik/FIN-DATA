package edu.uek.datamodeling.findata.model.findataimporter.model;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class FindataExchangeEntityModel.
 */
public class FindataExchangeEntityModel implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7727912917071524223L;

	/** The date. */
	private String date;
	
	/** The stock code. */
	private String stockCode;
	
	/** The stock name. */
	private String stockName;
	
	/** The company exchange model list. */
	private List<FindataCompanyExchangeModel> companyExchangeModelList;


	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Gets the stock code.
	 *
	 * @return the stock code
	 */
	public String getStockCode() {
		return stockCode;
	}

	/**
	 * Sets the stock code.
	 *
	 * @param stockCode the new stock code
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	/**
	 * Gets the stock name.
	 *
	 * @return the stock name
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * Sets the stock name.
	 *
	 * @param stockName the new stock name
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * Gets the company exchange model list.
	 *
	 * @return the company exchange model list
	 */
	public List<FindataCompanyExchangeModel> getCompanyExchangeModelList() {
		return companyExchangeModelList;
	}

	/**
	 * Sets the company exchange model list.
	 *
	 * @param companyExchangeModelList the new company exchange model list
	 */
	public void setCompanyExchangeModelList(
			List<FindataCompanyExchangeModel> companyExchangeModelList) {
		this.companyExchangeModelList = companyExchangeModelList;
	}
	
}
