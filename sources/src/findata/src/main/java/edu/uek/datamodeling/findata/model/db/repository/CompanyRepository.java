package edu.uek.datamodeling.findata.model.db.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.uek.datamodeling.findata.model.db.dao.CompanyDAO;
import edu.uek.datamodeling.findata.model.db.entity.Company;

// TODO: Auto-generated Javadoc
/**
 * The Class CompanyRepository.
 */
@Repository("companyRepository")
@Transactional
public class CompanyRepository implements CompanyDAO {

	/** The em. */
	@PersistenceContext
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.CompanyDAO#getCompany(java.lang.Integer)
	 */
	@Override
	public Company getCompany(Integer id) {
		return em.find(Company.class, id);
	}
	
	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.CompanyDAO#getCompanyByCode(java.lang.String)
	 */
	@Override
	public Company getCompanyByCode(String code) {
		TypedQuery<Company> query = em.createQuery("select c from Company c where c.code = :code", Company.class);
		query.setParameter("code", code);
		if (query.getResultList().isEmpty() == false) {
			return query.getSingleResult();
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.CompanyDAO#createCompany(edu.uek.datamodeling.findata.model.db.entity.Company)
	 */
	@Override
	public void createCompany(Company company) {
		em.persist(company);
	}
	
	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.CompanyDAO#updateCompany(edu.uek.datamodeling.findata.model.db.entity.Company)
	 */
	@Override
	public void updateCompany(Company company) {
		Company companyToUpdate = getCompany(company.getId());
		companyToUpdate.setStock(company.getStock());
		companyToUpdate.setCode(company.getCode());
		companyToUpdate.setFullName(company.getFullName());
		em.getTransaction().begin();
		em.merge(companyToUpdate);
		em.getTransaction().commit();
	}

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.CompanyDAO#getCopmaniesInStock(java.lang.Integer)
	 */
	@Override
	public List<Company> getCopmaniesInStock(Integer stockId) {
		TypedQuery<Company> query = em
				.createQuery("select c from Company c where c.stockId in "
						+ "(select s from Stock s where s.id = :stockId)", Company.class);
		query.setParameter("stockId", stockId);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.CompanyDAO#getCompaniesInStockByFirstLetter(java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<Company> getCompaniesInStockByFirstLetter(Integer stockId,
			String c) {
		TypedQuery<Company> query = em
				.createQuery("select c from Company c where c.stockId in "
						+ "(select s from Stock s where s.id = :stockId) "
						+ "and c.code like ':c%'" , Company.class);
		query.setParameter("stockId", stockId);
		query.setParameter("c", c);
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.model.db.dao.CompanyDAO#getAllCompanies()
	 */
	@Override
	public List<Company> getAllCompanies() {
		TypedQuery<Company> query = em.createQuery("select c from Company c", Company.class);
		return query.getResultList();
	}

	
	
}
