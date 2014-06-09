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
 * Object representation of "stocks" db relation
 *
 */
@Entity
@Table(name = "stocks")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stocks_id_stock_seq")
	@SequenceGenerator(name = "stocks_id_stock_seq", sequenceName = "stocks_id_stock_seq")
	@Column(name = "id_stock")
	private Integer id;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "full_name")
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
