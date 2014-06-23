package edu.uek.datamodeling.findata.model.findataimporter.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class FindataCompanyExchangeModel.
 */
public class FindataCompanyExchangeModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5976967693596576514L;
	
	/** The symbol. */
	private String symbol;
	
	/** The code. */
	private String code;
	
	/** The name. */
	private String name;
	
	/** The high. */
	private String high;
	
	/** The low. */
	private String low;
	
	/** The close. */
	private String close;
	
	/** The volume. */
	private String volume;
	
	/** The change. */
	private String change;

	/**
	 * Instantiates a new findata company exchange model.
	 *
	 * @param symbol the symbol
	 * @param code the code
	 * @param name the name
	 * @param high the high
	 * @param low the low
	 * @param close the close
	 * @param volume the volume
	 * @param change the change
	 */
	public FindataCompanyExchangeModel(String symbol,
			String code, String name, String high,
			String low, String close, String volume, String change) {
		this.symbol = symbol;
		this.code = code;
		this.name = name;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.change = change;
	}

	
	/**
	 * Gets the symbol.
	 *
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Sets the symbol.
	 *
	 * @param symbol the new symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the high.
	 *
	 * @return the high
	 */
	public String getHigh() {
		return high;
	}

	/**
	 * Sets the high.
	 *
	 * @param high the new high
	 */
	public void setHigh(String high) {
		this.high = high;
	}

	/**
	 * Gets the low.
	 *
	 * @return the low
	 */
	public String getLow() {
		return low;
	}

	/**
	 * Sets the low.
	 *
	 * @param low the new low
	 */
	public void setLow(String low) {
		this.low = low;
	}

	/**
	 * Gets the close.
	 *
	 * @return the close
	 */
	public String getClose() {
		return close;
	}

	/**
	 * Sets the close.
	 *
	 * @param close the new close
	 */
	public void setClose(String close) {
		this.close = close;
	}

	/**
	 * Gets the volume.
	 *
	 * @return the volume
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * Sets the volume.
	 *
	 * @param volume the new volume
	 */
	public void setVolume(String volume) {
		this.volume = volume;
	}

	/**
	 * Gets the change.
	 *
	 * @return the change
	 */
	public String getChange() {
		return change;
	}

	/**
	 * Sets the change.
	 *
	 * @param change the new change
	 */
	public void setChange(String change) {
		this.change = change;
	}

	/**
	 * Gets the serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
