package edu.uek.datamodeling.findata.model.db.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Company.
 *
 * @author Bartłomiej Mike
 *  
 * Object representation of "companies" db relation
 */
@Entity
@Table(name = "companies")
public class Company implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4283570436214349861L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companies_id_company_seq")
	@SequenceGenerator(name = "companies_id_company_seq", sequenceName = "companies_id_company_seq", allocationSize = 1, initialValue=1)
	@Column(name = "id_company")
	private Integer id;
	
	/** The stock. */
	@ManyToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;
	
	/** The code. */
	@Column(name = "code", nullable = false)
	private String code;
	
	/** The full name. */
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	/** The exchange set. */
	@OneToMany(mappedBy = "company")
	private Set<Exchange> exchangeSet;

	
	/**
	 * **********************************
	 * GENERATED  GETTERS  AND  SETTERS 
	 * **********************************.
	 *
	 * @return the id
	 */
	
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the stock.
	 *
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * Sets the stock.
	 *
	 * @param stock the new stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * Gets the exchange set.
	 *
	 * @return the exchange set
	 */
	public Set<Exchange> getExchangeSet() {
		return exchangeSet;
	}

	/**
	 * Sets the exchange set.
	 *
	 * @param exchangeSet the new exchange set
	 */
	public void setExchangeSet(Set<Exchange> exchangeSet) {
		this.exchangeSet = exchangeSet;
	}
	
}
