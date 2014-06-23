package edu.uek.datamodeling.findata.controller.implementation.extract.request;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ExtractRequest.
 */
public class ExtractRequest {
	
	/** The stock codes. */
	private List<String> stockCodes;
	
	/** The symbols. */
	private List<String> symbols;
	
	/**
	 * Instantiates a new extract request.
	 *
	 * @param stockCodes the stock codes
	 * @param symbols the symbols
	 */
	public ExtractRequest(List<String> stockCodes,
			List<String> symbols) {
		this.stockCodes = stockCodes;
		this.symbols = symbols;
	}

	/**
	 * Gets the stock codes.
	 *
	 * @return the stock codes
	 */
	public List<String> getStockCodes() {
		return stockCodes;
	}

	/**
	 * Sets the stock codes.
	 *
	 * @param stockCodes the new stock codes
	 */
	public void setStockCodes(List<String> stockCodes) {
		this.stockCodes = stockCodes;
	}

	/**
	 * Gets the symbols.
	 *
	 * @return the symbols
	 */
	public List<String> getSymbols() {
		return symbols;
	}

	/**
	 * Sets the symbols.
	 *
	 * @param symbols the new symbols
	 */
	public void setSymbols(List<String> symbols) {
		this.symbols = symbols;
	}
	
}
