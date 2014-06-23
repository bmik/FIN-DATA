package edu.uek.datamodeling.findata.model.db.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Exchange;

public interface ExchangeDAO extends Serializable {

	public Exchange getExchange(Integer id);
	public Exchange getExchangeByDateAndCompany(Date date, String code);
	public void createExchange(Exchange exchange);
	public List<Exchange> getExchangesForCompany(Integer companyId);
	public List<Exchange> getAllExchanges();
	
}
