package edu.uek.datamodeling.findata.model.findataimporter;

/**
 * @author Bartłomiej Mike
 * 
 * TODO komentarz
 *
 */
public class URLBuilder {

	private static final String HOST_NAME = "http://www.findata.co.nz";
	private static final String MARKETS_PATH = "/markets";
	private static final String SYMBOLS_PATH = "/symbols";
	private static final String DEFAULT_RESOURCE = "/default";
	private static final String RESOURCE_TYPE = ".htm";
	
	public static String getStockURL(String stockCode) {
		StringBuffer sb = new StringBuffer();
		sb.append(HOST_NAME);
		sb.append(MARKETS_PATH);
		sb.append("/" + stockCode.toLowerCase());
		sb.append(DEFAULT_RESOURCE);
		sb.append(RESOURCE_TYPE);
		
		return sb.toString();
	}
	
	public static String getStockWithSymbolURL(String stockCode, String sybmol) {
		StringBuffer sb = new StringBuffer();
		sb.append(HOST_NAME);
		sb.append(MARKETS_PATH);
		sb.append("/" + stockCode.toUpperCase());
		sb.append(SYMBOLS_PATH);
		sb.append("/" + sybmol.toUpperCase());
		sb.append(RESOURCE_TYPE);
		
		return sb.toString();
	}
	
}
