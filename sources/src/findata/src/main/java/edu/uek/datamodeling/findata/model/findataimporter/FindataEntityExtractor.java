package edu.uek.datamodeling.findata.model.findataimporter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.uek.datamodeling.findata.model.findataimporter.connection.Connector;
import edu.uek.datamodeling.findata.model.findataimporter.connection.URLBuilder;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataCompanyExchangeModel;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataExchangeEntityModel;

// TODO: Auto-generated Javadoc
/**
 * The Class FindataEntityExtractor.
 */
public class FindataEntityExtractor implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6801327717142363078L;
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(FindataEntityExtractor.class);

	/**
	 * Gets the findata exchange model.
	 *
	 * @param stockCode the stock code
	 * @param symbols the symbols
	 * @return the findata exchange model
	 */
	public static FindataExchangeEntityModel getFindataExchangeModel(
			String stockCode, List<String> symbols) {
		
		log.info(String.format("Preparing to create Findata Entity Model for stock with code: %s", stockCode));
		
		FindataExchangeEntityModel model = new FindataExchangeEntityModel();

		String stockUrl = URLBuilder.getStockURL(stockCode);
		Document stockPage = Connector.getPage(stockUrl);
		
		String stockName = stockPage.select(".pagetitle h2").text();
		String date = stockPage.select("#date span").text();
		
		model.setStockCode(stockCode);
		model.setDate(date);
		model.setStockName(stockName);
		
		for (String symbol : symbols) {
			
			log.info(String.format("Preparing to obtain exchanges from companies with letter %s", symbol));
			
			List<FindataCompanyExchangeModel> rows = new ArrayList<FindataCompanyExchangeModel>();

			String symbolsUrl = URLBuilder.getStockWithSymbolURL(stockCode, symbol);
			Document symbolsPage = Connector.getPage(symbolsUrl);

			Elements trRows = symbolsPage.select(".quotes tr");
			trRows.remove(0);

			for (Element e : trRows) {
				rows.add(new FindataCompanyExchangeModel(symbol, getCode(e), getName(e),
						getHigh(e), getLow(e), getClose(e), getVolume(e),
						getChange(e)));
			}
			
			if (model.getCompanyExchangeModelList() == null) {
				model.setCompanyExchangeModelList(new ArrayList<FindataCompanyExchangeModel>());
			}
			
			log.info(String.format("Successfully obtained all exchange date from companies with letter %s", symbol));
			
			model.getCompanyExchangeModelList().addAll(rows);
		}
		
		log.info(String.format("Successfully created Findata Entity model for stock with code: %s", stockCode));

		return model;
	}

	/**
	 * Gets the code.
	 *
	 * @param e the e
	 * @return the code
	 */
	private static String getCode(Element e) {
		return e.select("a").text();
	}

	/**
	 * Gets the name.
	 *
	 * @param e the e
	 * @return the name
	 */
	private static String getName(Element e) {
		return e.select("td").get(1).text();
	}

	/**
	 * Gets the high.
	 *
	 * @param e the e
	 * @return the high
	 */
	private static String getHigh(Element e) {
		return e.select("td").get(2).text();
	}

	/**
	 * Gets the low.
	 *
	 * @param e the e
	 * @return the low
	 */
	private static String getLow(Element e) {
		return e.select("td").get(3).text();
	}

	/**
	 * Gets the close.
	 *
	 * @param e the e
	 * @return the close
	 */
	private static String getClose(Element e) {
		return e.select("td").get(4).text();
	}

	/**
	 * Gets the volume.
	 *
	 * @param e the e
	 * @return the volume
	 */
	private static String getVolume(Element e) {
		return e.select("td").get(5).text();
	}

	/**
	 * Gets the change.
	 *
	 * @param e the e
	 * @return the change
	 */
	private static String getChange(Element e) {
		return e.select("td").get(6).text();
	}

}
