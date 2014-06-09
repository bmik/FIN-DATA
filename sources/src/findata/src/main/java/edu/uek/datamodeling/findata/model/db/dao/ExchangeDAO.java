package edu.uek.datamodeling.findata.model.db.dao;

import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Exchange;

public interface ExchangeDAO {

	public Exchange getExchange(Integer id);
	public void createExchange(Exchange exchange);
	public List<Exchange> getExchangesForCompany(Integer companyId);
	public List<Exchange> getAllExchanges();
	
}
