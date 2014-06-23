package edu.uek.datamodeling.findata.controller.service;

import java.io.Serializable;

import edu.uek.datamodeling.findata.controller.implementation.transform.request.TransformRequest;
import edu.uek.datamodeling.findata.controller.implementation.transform.response.TransformResponse;

public interface TransformService extends Serializable {

	public TransformResponse doTransform(TransformRequest request);
	
}
