package edu.uek.datamodeling.findata.model.db.dao;

import java.io.Serializable;
import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Company;

// TODO: Auto-generated Javadoc
/**
 * The Interface CompanyDAO.
 */
public interface CompanyDAO extends Serializable {

	/**
	 * Gets the company.
	 *
	 * @param id the id
	 * @return the company
	 */
	public Company getCompany(Integer id);
	
	/**
	 * Gets the company by code.
	 *
	 * @param code the code
	 * @return the company by code
	 */
	public Company getCompanyByCode(String code);
	
	/**
	 * Creates the company.
	 *
	 * @param company the company
	 */
	public void createCompany(Company company);
	
	/**
	 * Update company.
	 *
	 * @param company the company
	 */
	public void updateCompany(Company company);
	
	/**
	 * Gets the copmanies in stock.
	 *
	 * @param stockId the stock id
	 * @return the copmanies in stock
	 */
	public List<Company> getCopmaniesInStock(Integer stockId);
	
	/**
	 * Gets the companies in stock by first letter.
	 *
	 * @param stockId the stock id
	 * @param c the c
	 * @return the companies in stock by first letter
	 */
	public List<Company> getCompaniesInStockByFirstLetter(Integer stockId, String c);
	
	/**
	 * Gets the all companies.
	 *
	 * @return the all companies
	 */
	public List<Company> getAllCompanies();
	
}
