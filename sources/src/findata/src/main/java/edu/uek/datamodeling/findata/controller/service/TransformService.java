package edu.uek.datamodeling.findata.controller.service;

import edu.uek.datamodeling.findata.controller.implementation.transform.TransformRequest;
import edu.uek.datamodeling.findata.controller.implementation.transform.TransformResponse;

public interface TransformService {

	public TransformResponse doTransform(TransformRequest request);
	
}
