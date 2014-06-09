package edu.uek.datamodeling.findata.model.db.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.uek.datamodeling.findata.model.db.dao.StockDAO;
import edu.uek.datamodeling.findata.model.db.entity.Stock;

@Repository("stockRepository")
public class StockRepository implements StockDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Stock getStock(Integer id) {
		return em.find(Stock.class, id);
	}
	
	@Override
	@Transactional
	public void createStock(Stock stock) {
		em.persist(stock);
	}

	@Override
	public List<Stock> getAllStocks() {
		TypedQuery<Stock> query = em.createQuery("select s from Stock s", Stock.class);
		return query.getResultList();
	}

}
