package edu.uek.datamodeling.findata.model.db.entity;

import java.util.Date;

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
 * Object representation of "exchanges" db relation
 *
 */
@Entity
@Table(name = "exchanges")
public class Exchange {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exchanges_id_exchange_seq")
	@SequenceGenerator(name = "exchanges_id_exchange_seq", sequenceName = "exchanges_id_exchange_seq")
	@Column(name = "id_exchange")
	private Integer id;
	
	@Column(name = "company_id", nullable = false)
	private Integer companyId;

	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "highest_value")
	private Float highestValue;
	
	@Column(name = "lowest_value")
	private Float lowestValue;
	
	@Column(name = "closing_value")
	private Float closingValue;
	
	@Column(name = "change_value")
	private Float changeValue;

	
	/************************************
	 * GENERATED  GETTERS  AND  SETTERS 
	 ************************************/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getHighestValue() {
		return highestValue;
	}

	public void setHighestValue(Float highestValue) {
		this.highestValue = highestValue;
	}

	public Float getLowestValue() {
		return lowestValue;
	}

	public void setLowestValue(Float lowestValue) {
		this.lowestValue = lowestValue;
	}

	public Float getClosingValue() {
		return closingValue;
	}

	public void setClosingValue(Float closingValue) {
		this.closingValue = closingValue;
	}

	public Float getChangeValue() {
		return changeValue;
	}

	public void setChangeValue(Float changeValue) {
		this.changeValue = changeValue;
	}
	
}
