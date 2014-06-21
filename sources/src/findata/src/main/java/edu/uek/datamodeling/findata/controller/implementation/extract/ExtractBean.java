package edu.uek.datamodeling.findata.controller.implementation.extract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.uek.datamodeling.findata.controller.implementation.enums.ResponseStatus;
import edu.uek.datamodeling.findata.controller.implementation.extract.request.ExtractRequest;
import edu.uek.datamodeling.findata.controller.implementation.extract.response.ExtractResponse;
import edu.uek.datamodeling.findata.controller.service.ExtractService;
import edu.uek.datamodeling.findata.model.findataimporter.FindataEntityExtractor;
import edu.uek.datamodeling.findata.model.findataimporter.model.FindataExchangeEntityModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ExtractBean.
 */
@Service("extractService")
public class ExtractBean implements ExtractService, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1592037509045427193L;

	/* (non-Javadoc)
	 * @see edu.uek.datamodeling.findata.controller.service.ExtractService#doExtract(edu.uek.datamodeling.findata.controller.implementation.extract.request.ExtractRequest)
	 */
	@Override
	public ExtractResponse doExtract(
			ExtractRequest request) {
		
		ExtractResponse response = new ExtractResponse();
		
		if (request.getStockCodes() == null || request.getStockCodes().isEmpty() == true
				|| request.getSymbols() == null || request.getSymbols().isEmpty() == true) {
			response.setStatus(ResponseStatus.ERROR);
			response.setDesc("Parameters problem!");
			return response;
		}
		
		List<FindataExchangeEntityModel> entityModelList = new ArrayList<FindataExchangeEntityModel>();
			
		for (String stock : request.getStockCodes()) {
			entityModelList.add(FindataEntityExtractor.getFindataExchangeModel(stock, request.getSymbols()));
		}
		
		response.setFindataExchangeEntityModelList(entityModelList);
		response.setStatus(ResponseStatus.SUCCESS);
		
		return response;
		
	}

}
