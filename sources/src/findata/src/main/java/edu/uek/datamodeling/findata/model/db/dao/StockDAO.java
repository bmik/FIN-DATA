package edu.uek.datamodeling.findata.model.db.dao;

import java.io.Serializable;
import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Stock;

public interface StockDAO extends Serializable {

	public Stock getStock(Integer id);
	public Stock getStockByCode(String code);
	public Stock getStockByName(String name);
	public void createStock(Stock stock);
	public List<Stock> getAllStocks();
	
}
