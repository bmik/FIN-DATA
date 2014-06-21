package edu.uek.datamodeling.findata.controller.implementation.transform.request;

import java.io.Serializable;
import java.util.List;

import edu.uek.datamodeling.findata.model.findataimporter.model.FindataExchangeEntityModel;

// TODO: Auto-generated Javadoc
/**
 * The Class TransformRequest.
 */
public class TransformRequest implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4209884767344224304L;

	/** The findata entities to transform. */
	private List<FindataExchangeEntityModel> findataEntitiesToTransform;
	

	/**
	 * Instantiates a new transform request.
	 *
	 * @param findataEntitiesToTransform the findata entities to transform
	 */
	public TransformRequest(
			List<FindataExchangeEntityModel> findataEntitiesToTransform) {
		this.findataEntitiesToTransform = findataEntitiesToTransform;
	}
	

	/**
	 * Gets the findata entities to transform.
	 *
	 * @return the findata entities to transform
	 */
	public List<FindataExchangeEntityModel> getFindataEntitiesToTransform() {
		return findataEntitiesToTransform;
	}

	/**
	 * Sets the findata entities to transform.
	 *
	 * @param findataEntitiesToTransform the new findata entities to transform
	 */
	public void setFindataEntitiesToTransform(
			List<FindataExchangeEntityModel> findataEntitiesToTransform) {
		this.findataEntitiesToTransform = findataEntitiesToTransform;
	}
	
}
