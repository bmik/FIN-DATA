package edu.uek.datamodeling.findata.model.findataimporter.connection;

// TODO: Auto-generated Javadoc
/**
 * The Class URLBuilder.
 *
 * @author Bartłomiej Mike
 * 
 * TODO komentarz
 */
public class URLBuilder {

	/** The Constant HOST_NAME. */
	private static final String HOST_NAME = "http://www.findata.co.nz";
	
	/** The Constant MARKETS_PATH. */
	private static final String MARKETS_PATH = "/markets";
	
	/** The Constant SYMBOLS_PATH. */
	private static final String SYMBOLS_PATH = "/symbols";
	
	/** The Constant DEFAULT_RESOURCE. */
	private static final String DEFAULT_RESOURCE = "/default";
	
	/** The Constant RESOURCE_TYPE. */
	private static final String RESOURCE_TYPE = ".htm";
	
	/**
	 * Gets the stock url.
	 *
	 * @param stockCode the stock code
	 * @return the stock url
	 */
	public static String getStockURL(String stockCode) {
		StringBuffer sb = new StringBuffer();
		sb.append(HOST_NAME);
		sb.append(MARKETS_PATH);
		sb.append("/" + stockCode.toLowerCase());
		sb.append(DEFAULT_RESOURCE);
		sb.append(RESOURCE_TYPE);
		
		return sb.toString();
	}
	
	/**
	 * Gets the stock with symbol url.
	 *
	 * @param stockCode the stock code
	 * @param symbol the symbol
	 * @return the stock with symbol url
	 */
	public static String getStockWithSymbolURL(String stockCode, String symbol) {
		StringBuffer sb = new StringBuffer();
		sb.append(HOST_NAME);
		sb.append(MARKETS_PATH);
		sb.append("/" + stockCode.toUpperCase());
		sb.append(SYMBOLS_PATH);
		sb.append("/" + symbol.toUpperCase());
		sb.append(RESOURCE_TYPE);
		
		return sb.toString();
	}
	
}
