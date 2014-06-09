package edu.uek.datamodeling.findata.controller.service;

import edu.uek.datamodeling.findata.controller.implementation.load.LoadRequest;
import edu.uek.datamodeling.findata.controller.implementation.load.LoadResponse;

public interface LoadService {

	public LoadResponse doLoad(LoadRequest request);
	
}
