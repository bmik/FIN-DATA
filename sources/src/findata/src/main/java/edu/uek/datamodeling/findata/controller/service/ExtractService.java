package edu.uek.datamodeling.findata.controller.service;

import java.io.Serializable;

import edu.uek.datamodeling.findata.controller.implementation.extract.request.ExtractRequest;
import edu.uek.datamodeling.findata.controller.implementation.extract.response.ExtractResponse;

public interface ExtractService extends Serializable {
	
	public ExtractResponse doExtract(ExtractRequest request);
	
}
