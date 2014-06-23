package edu.uek.datamodeling.findata.model.db.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.uek.datamodeling.findata.model.db.dao.CompanyDAO;
import edu.uek.datamodeling.findata.model.db.entity.Company;

@Repository("companyRepository")
@Transactional
public class CompanyRepository implements CompanyDAO {

	private static final long serialVersionUID = 299462326124267592L;

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Company getCompany(Integer id) {
		return em.find(Company.class, id);
	}
	
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

	@Override
	public void createCompany(Company company) {
		em.persist(company);
	}
	
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

	@Override
	public List<Company> getCopmaniesInStock(Integer stockId) {
		TypedQuery<Company> query = em
				.createQuery("select c from Company c where c.stockId in "
						+ "(select s from Stock s where s.id = :stockId)", Company.class);
		query.setParameter("stockId", stockId);
		return query.getResultList();
	}

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

	@Override
	public List<Company> getAllCompanies() {
		TypedQuery<Company> query = em.createQuery("select c from Company c", Company.class);
		return query.getResultList();
	}
	
}
