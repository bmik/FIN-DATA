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
@Transactional
public class StockRepository implements StockDAO {

	private static final long serialVersionUID = 4515200071268133289L;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Stock getStock(Integer id) {
		return em.find(Stock.class, id);
	}

	@Override
	public Stock getStockByCode(String code) {
		TypedQuery<Stock> query = em.createQuery("select s from Stock s where s.code = :code", Stock.class);
		query.setParameter("code", code);
		if (query.getResultList().isEmpty() == false) {
			return query.getSingleResult();
		} else {
			return null;
		}
	}

	@Override
	public Stock getStockByName(String name) {
		TypedQuery<Stock> query = em.createQuery("select s from Stock s where s.fullName = :name", Stock.class);
		query.setParameter("name", name);
		if (query.getResultList().isEmpty() == false) {
			return query.getSingleResult();
		} else {
			return null;
		}
	}
	
	@Override
	public void createStock(Stock stock) {
		em.persist(stock);
	}

	@Override
	public List<Stock> getAllStocks() {
		TypedQuery<Stock> query = em.createQuery("select s from Stock s", Stock.class);
		return query.getResultList();
	}

}
