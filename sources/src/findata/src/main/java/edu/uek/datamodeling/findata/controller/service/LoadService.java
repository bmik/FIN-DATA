package edu.uek.datamodeling.findata.controller.service;

import java.io.Serializable;

import edu.uek.datamodeling.findata.controller.implementation.load.request.LoadRequest;
import edu.uek.datamodeling.findata.controller.implementation.load.response.LoadResponse;

public interface LoadService extends Serializable {

	public LoadResponse doLoad(LoadRequest request);
	
}
