package edu.uek.datamodeling.findata.model.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Exchange.
 *
 * @author Bartłomiej Mike
 *  
 * Object representation of "exchanges" db relation
 */
@Entity
@Table(name = "exchanges")
public class Exchange implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5070910773326843417L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exchanges_id_exchange_seq")
	@SequenceGenerator(name = "exchanges_id_exchange_seq", sequenceName = "exchanges_id_exchange_seq", allocationSize = 1, initialValue=1)
	@Column(name = "id_exchange")
	private Integer id;
	
	/** The company. */
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	/** The date. */
	@Column(name = "date", nullable = false)
	private Date date;
	
	/** The highest value. */
	@Column(name = "highest_value")
	private Float highestValue;
	
	/** The lowest value. */
	@Column(name = "lowest_value")
	private Float lowestValue;
	
	/** The closing value. */
	@Column(name = "closing_value")
	private Float closingValue;
	
	/** The volume value. */
	@Column(name = "volume_value")
	private Float volumeValue;
	
	/** The change value. */
	@Column(name = "change_value")
	private Float changeValue;

	
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
	 * Gets the company.
	 *
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * Sets the company.
	 *
	 * @param company the new company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the highest value.
	 *
	 * @return the highest value
	 */
	public Float getHighestValue() {
		return highestValue;
	}

	/**
	 * Sets the highest value.
	 *
	 * @param highestValue the new highest value
	 */
	public void setHighestValue(Float highestValue) {
		this.highestValue = highestValue;
	}

	/**
	 * Gets the lowest value.
	 *
	 * @return the lowest value
	 */
	public Float getLowestValue() {
		return lowestValue;
	}

	/**
	 * Sets the lowest value.
	 *
	 * @param lowestValue the new lowest value
	 */
	public void setLowestValue(Float lowestValue) {
		this.lowestValue = lowestValue;
	}

	/**
	 * Gets the closing value.
	 *
	 * @return the closing value
	 */
	public Float getClosingValue() {
		return closingValue;
	}

	/**
	 * Sets the closing value.
	 *
	 * @param closingValue the new closing value
	 */
	public void setClosingValue(Float closingValue) {
		this.closingValue = closingValue;
	}

	/**
	 * Gets the volume value.
	 *
	 * @return the volume value
	 */
	public Float getVolumeValue() {
		return volumeValue;
	}

	/**
	 * Sets the volume value.
	 *
	 * @param volumeValue the new volume value
	 */
	public void setVolumeValue(Float volumeValue) {
		this.volumeValue = volumeValue;
	}

	/**
	 * Gets the change value.
	 *
	 * @return the change value
	 */
	public Float getChangeValue() {
		return changeValue;
	}

	/**
	 * Sets the change value.
	 *
	 * @param changeValue the new change value
	 */
	public void setChangeValue(Float changeValue) {
		this.changeValue = changeValue;
	}
	
}
