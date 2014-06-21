package edu.uek.datamodeling.findata.controller.service;

import edu.uek.datamodeling.findata.controller.implementation.load.request.LoadRequest;
import edu.uek.datamodeling.findata.controller.implementation.load.response.LoadResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoadService.
 */
public interface LoadService {

	/**
	 * Do load.
	 *
	 * @param request the request
	 * @return the load response
	 */
	public LoadResponse doLoad(LoadRequest request);
	
}
