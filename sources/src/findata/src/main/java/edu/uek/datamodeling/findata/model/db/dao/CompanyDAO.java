package edu.uek.datamodeling.findata.model.db.dao;

import java.util.List;

import edu.uek.datamodeling.findata.model.db.entity.Company;

public interface CompanyDAO {

	public Company getCompany(Integer id);
	public void createCompany(Company company);
	public void updateCompany(Company company);
	public List<Company> getCopmaniesInStock(Integer stockId);
	public List<Company> getCompaniesInStockByFirstLetter(Integer stockId, String c);
	public List<Company> getAllCompanies();
	
}
