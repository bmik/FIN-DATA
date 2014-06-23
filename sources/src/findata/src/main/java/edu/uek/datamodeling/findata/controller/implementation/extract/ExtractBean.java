package edu.uek.datamodeling.findata.controller.implementation.extract;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import edu.uek.datamodeling.findata.controller.implementation.enums.ResponseStatus;
import edu.uek.datamodeling.findata.controller.implementation.extract.request.ExtractRequest;
import edu.uek.datamodeling.findata.controller.implementation.extract.response.ExtractResponse;
import edu.uek.datamodeling.findata.controller.service.ExtractService;
import edu.uek.datamodeling.findata.model.findataimporter.FindataEntityExtractor;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataExchangeEntityModel;

@Service("extractService")
public class ExtractBean implements ExtractService {

	private static final long serialVersionUID = 1592037509045427193L;
	
	private static final Logger log = Logger.getLogger(ExtractService.class);

	@Override
	public ExtractResponse doExtract(
			ExtractRequest request) {
		
		ExtractResponse response = new ExtractResponse();
		
		if (request.getStockCodes() == null || request.getStockCodes().isEmpty() == true
				|| request.getSymbols() == null || request.getSymbols().isEmpty() == true) {
			log.error(String.format("Request parameters resolved to null or empty!"));
			response.setStatus(ResponseStatus.ERROR);
			response.setDesc("Parameters problem!");
			
			return response;
		}
		
		log.info(String.format("*********************************************************************************"));
		log.info(String.format("****     EXTRACT  SERVICE     ***************************************************"));
		log.info(String.format("*********************************************************************************"));
		
		List<FindataExchangeEntityModel> entityModelList = new ArrayList<FindataExchangeEntityModel>();
			
		log.info(String.format("Attempting to obtain Findata Entities from Findata Extractor..."));
		for (String stock : request.getStockCodes()) {
			entityModelList.add(FindataEntityExtractor.getFindataExchangeModel(stock, request.getSymbols()));
		}
		
		log.info(String.format("Successfully obtained Findata Entity List."));
		
		response.setFindataExchangeEntityModelList(entityModelList);
		response.setStatus(ResponseStatus.SUCCESS);
		
		return response;
		
	}

}
