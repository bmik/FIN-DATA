package edu.uek.datamodeling.findata.model.db.dao;

import java.io.Serializable;
import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Stock;

// TODO: Auto-generated Javadoc
/**
 * The Interface StockDAO.
 */
public interface StockDAO extends Serializable {

	/**
	 * Gets the stock.
	 *
	 * @param id the id
	 * @return the stock
	 */
	public Stock getStock(Integer id);
	
	/**
	 * Gets the stock by code.
	 *
	 * @param code the code
	 * @return the stock by code
	 */
	public Stock getStockByCode(String code);
	
	/**
	 * Gets the stock by name.
	 *
	 * @param name the name
	 * @return the stock by name
	 */
	public Stock getStockByName(String name);
	
	/**
	 * Creates the stock.
	 *
	 * @param stock the stock
	 */
	public void createStock(Stock stock);
	
	/**
	 * Gets the all stocks.
	 *
	 * @return the all stocks
	 */
	public List<Stock> getAllStocks();
	
}
