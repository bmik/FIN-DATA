package edu.uek.datamodeling.findata.model.db.dao;

import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Stock;

public interface StockDAO {

	public Stock getStock(Integer id);
	public void createStock(Stock stock);
	public List<Stock> getAllStocks();
	
}
