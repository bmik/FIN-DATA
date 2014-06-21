package edu.uek.datamodeling.findata.model.db.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Stock.
 *
 * @author Bartłomiej Mike
 * 
 * Object representation of "stocks" db relation
 */
@Entity
@Table(name = "stocks")
public class Stock implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4783931510698090642L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stocks_id_stock_seq")
	@SequenceGenerator(name = "stocks_id_stock_seq", sequenceName = "stocks_id_stock_seq", allocationSize = 1, initialValue=1)
	@Column(name = "id_stock")
	private Integer id;
	
	/** The code. */
	@Column(name = "code", nullable = false)
	private String code;
	
	/** The full name. */
	@Column(name = "full_name")
	private String fullName;
	
	/** The company set. */
	@OneToMany(mappedBy = "stock")
	private Set<Company> companySet;

	
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
	 * Gets the company set.
	 *
	 * @return the company set
	 */
	public Set<Company> getCompanySet() {
		return companySet;
	}

	/**
	 * Sets the company set.
	 *
	 * @param companySet the new company set
	 */
	public void setCompanySet(Set<Company> companySet) {
		this.companySet = companySet;
	}
	
}
