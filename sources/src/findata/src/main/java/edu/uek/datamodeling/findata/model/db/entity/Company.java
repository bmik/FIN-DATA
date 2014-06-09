package edu.uek.datamodeling.findata.model.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Bartłomiej Mike
 *  
 * Object representation of "companies" db relation
 *
 */
@Entity
@Table(name = "companies")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companies_id_company_seq")
	@SequenceGenerator(name = "companies_id_company_seq", sequenceName = "companies_id_company_seq")
	@Column(name = "id_company")
	private Integer id;
	
	@Column(name = "stock_id", nullable = false)
	private Integer stock;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;

	
	/************************************
	 * GENERATED  GETTERS  AND  SETTERS 
	 ************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
