package edu.uek.datamodeling.findata.model.db.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.uek.datamodeling.findata.model.db.dao.StockDAO;
import edu.uek.datamodeling.findata.model.db.entity.Stock;

// TODO: Auto-generated Javadoc
/**
 * The Class StockRepository.
 */
@Repository("stockRepository")
@Transactional
public class StockRepository implements StockDAO {

	/** The em. */
	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.StockDAO#getStock(java.lang.Integer)
	 */
	@Override
	public Stock getStock(Integer id) {
		return em.find(Stock.class, id);
	}

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.StockDAO#getStockByCode(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.StockDAO#getStockByName(java.lang.String)
	 */
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
	
	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.StockDAO#createStock(edu.uek.datamodeling.findata.model.db.entity.Stock)
	 */
	@Override
	public void createStock(Stock stock) {
		em.persist(stock);
	}

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.StockDAO#getAllStocks()
	 */
	@Override
	public List<Stock> getAllStocks() {
		TypedQuery<Stock> query = em.createQuery("select s from Stock s", Stock.class);
		return query.getResultList();
	}

}
