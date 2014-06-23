package edu.uek.datamodeling.findata.model.db.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Exchange;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExchangeDAO.
 */
public interface ExchangeDAO extends Serializable {

	/**
	 * Gets the exchange.
	 *
	 * @param id the id
	 * @return the exchange
	 */
	public Exchange getExchange(Integer id);
	
	/**
	 * Gets the exchange by date and company.
	 *
	 * @param date the date
	 * @param code the code
	 * @return the exchange by date and company
	 */
	public Exchange getExchangeByDateAndCompany(Date date, String code);
	
	/**
	 * Creates the exchange.
	 *
	 * @param exchange the exchange
	 */
	public void createExchange(Exchange exchange);
	
	/**
	 * Gets the exchanges for company.
	 *
	 * @param companyId the company id
	 * @return the exchanges for company
	 */
	public List<Exchange> getExchangesForCompany(Integer companyId);
	
	/**
	 * Gets the all exchanges.
	 *
	 * @return the all exchanges
	 */
	public List<Exchange> getAllExchanges();
	
}
