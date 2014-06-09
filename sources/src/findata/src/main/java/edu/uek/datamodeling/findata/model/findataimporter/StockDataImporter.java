package edu.uek.datamodeling.findata.model.findataimporter;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StockDataImporter {
	
	private static final Logger log = Logger.getLogger(StockDataImporter.class);

	public static String getStockFullName(String stockCode) {
		String fullName = "";
		try {
			Document page = Jsoup.connect(URLBuilder.getStockURL(stockCode)).get();
			fullName = page.select(".pagetitle h2").get(0).text();
		} catch (IOException e) {
			log.error(String.format("Unable to get stock full name from given address: %s", URLBuilder.getStockURL(stockCode)));
		}
		return fullName;
	}
	
}