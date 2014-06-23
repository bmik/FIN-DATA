package edu.uek.datamodeling.findata.model.findataimporter.connection;

import java.io.IOException;
import java.io.Serializable;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import edu.uek.datamodeling.findata.model.findataimporter.FindataEntityExtractor;


// TODO: Auto-generated Javadoc
/**
 * The Class Connector.
 */
public class Connector implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1212271992192666407L;
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(FindataEntityExtractor.class);

	/** The current url. */
	private static String currentUrl;
	
	/**
	 * Instantiates a new connector.
	 */
	private Connector() {
	}
	
	/**
	 * Gets the page.
	 *
	 * @param url the url
	 * @return the page
	 */
	public static Document getPage(String url) {

		if (currentUrl == null || currentUrl.equals(url) == false) {
			currentUrl = url;
		} 
		
		Document page = null;
		
		try {
			log.info(String.format("Trying to get page content from URL: %s", url));
			page = Jsoup.connect(currentUrl).timeout(5000).get();
			log.info(String.format("Page content successfully loaded"));
		} catch (IOException e) {
			log.error(String.format("Unable to get page content from URL %s: %s", url, e.getCause()));
		}
		
		return page;
	}

}
