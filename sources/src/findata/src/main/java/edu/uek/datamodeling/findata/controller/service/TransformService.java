package edu.uek.datamodeling.findata.controller.service;

import edu.uek.datamodeling.findata.controller.implementation.transform.request.TransformRequest;
import edu.uek.datamodeling.findata.controller.implementation.transform.response.TransformResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface TransformService.
 */
public interface TransformService {

	/**
	 * Do transform.
	 *
	 * @param request the request
	 * @return the transform response
	 */
	public TransformResponse doTransform(TransformRequest request);
	
}
