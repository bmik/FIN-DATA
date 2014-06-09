package edu.uek.datamodeling.findata.controller.service;

import edu.uek.datamodeling.findata.controller.implementation.extract.ExtractRequest;
import edu.uek.datamodeling.findata.controller.implementation.extract.ExtractResponse;
import edu.uek.datamodeling.findata.controller.implementation.extract.ExtractStockRequest;
import edu.uek.datamodeling.findata.controller.implementation.extract.ExtractStockResponse;

public interface ExtractService {

	// General extract process
	public ExtractResponse doExtract(ExtractRequest request);
	public ExtractStockResponse extractStock(ExtractStockRequest request);
	
}
