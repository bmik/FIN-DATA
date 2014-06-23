package edu.uek.datamodeling.findata.controller.implementation.extract.response;

import java.util.List;

import edu.uek.datamodeling.findata.controller.implementation.Response;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataExchangeEntityModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ExtractResponse.
 */
public class ExtractResponse extends Response {

	/** The findata exchange entity model list. */
	private List<FindataExchangeEntityModel> findataExchangeEntityModelList;

	/**
	 * Gets the findata exchange entity model list.
	 *
	 * @return the findata exchange entity model list
	 */
	public List<FindataExchangeEntityModel> getFindataExchangeEntityModelList() {
		return findataExchangeEntityModelList;
	}

	/**
	 * Sets the findata exchange entity model list.
	 *
	 * @param findataExchangeEntityModelList the new findata exchange entity model list
	 */
	public void setFindataExchangeEntityModelList(
			List<FindataExchangeEntityModel> findataExchangeEntityModelList) {
		this.findataExchangeEntityModelList = findataExchangeEntityModelList;
	}
	
}
