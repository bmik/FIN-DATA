package edu.uek.datamodeling.findata.model.db.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.uek.datamodeling.findata.model.db.dao.ExchangeDAO;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;

@Repository("exchangeRepository")
public class ExchangeRepository implements ExchangeDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Exchange getExchange(Integer id) {
		return em.find(Exchange.class, id);
	}

	@Override
	@Transactional
	public void createExchange(Exchange exchange) {
		em.persist(exchange);
	}

	@Override
	public List<Exchange> getExchangesForCompany(Integer companyId) {
		TypedQuery<Exchange> query = em
				.createQuery("select e from Exchange e where e.companyId in "
						+ "(select c from Company c where c.id = :companyId)", Exchange.class);
		query.setParameter("companyId", companyId);
		return query.getResultList();
	}

	@Override
	public List<Exchange> getAllExchanges() {
		TypedQuery<Exchange> query = em.createQuery("select e from Exchange e", Exchange.class);
		return query.getResultList();
	}

}
