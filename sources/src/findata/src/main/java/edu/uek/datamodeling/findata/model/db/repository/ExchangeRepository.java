package edu.uek.datamodeling.findata.model.db.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.uek.datamodeling.findata.model.db.dao.ExchangeDAO;
import edu.uek.datamodeling.findata.model.db.entity.Exchange;

@Repository("exchangeRepository")
@Transactional
public class ExchangeRepository implements ExchangeDAO {
	
	private static final long serialVersionUID = 5091742627841679434L;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Exchange getExchange(Integer id) {
		return em.find(Exchange.class, id);
	}
	
	@Override
	public Exchange getExchangeByDateAndCompany(Date date, String code) {
		TypedQuery<Exchange> query = em.createQuery("select e from Exchange e where e.date = :date and e.company in "
												+ "(select c from Company c where c.code = :code)", Exchange.class);
		query.setParameter("date", date);
		query.setParameter("code", code);
		if (query.getResultList().isEmpty() == false) {
			return query.getSingleResult();
		} else {
			return null;
		}
	}

	@Override
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
