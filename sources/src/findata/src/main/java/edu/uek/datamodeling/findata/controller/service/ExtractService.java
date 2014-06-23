package edu.uek.datamodeling.findata.controller.service;

import java.io.Serializable;

import edu.uek.datamodeling.findata.controller.implementation.extract.request.ExtractRequest;
import edu.uek.datamodeling.findata.controller.implementation.extract.response.ExtractResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExtractService.
 */
public interface ExtractService extends Serializable {
	
	/**
	 * Do extract.
	 *
	 * @param request the request
	 * @return the extract response
	 */
	public ExtractResponse doExtract(ExtractRequest request);
	
}
