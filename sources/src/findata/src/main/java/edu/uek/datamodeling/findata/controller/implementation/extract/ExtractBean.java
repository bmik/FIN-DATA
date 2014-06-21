package edu.uek.datamodeling.findata.controller.implementation.extract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uek.datamodeling.findata.controller.implementation.enums.ResponseStatus;
import edu.uek.datamodeling.findata.controller.service.ExtractService;
import edu.uek.datamodeling.findata.model.db.dao.StockDAO;
import edu.uek.datamodeling.findata.model.findataimporter.StockDataImporter;

@Service("extractService")
public class Extract implements ExtractService {
	
	@Autowired
	private StockDAO stockDAO;

	@Override
	public ExtractResponse doExtract(ExtractRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtractStockResponse extractStock(ExtractStockRequest request) {
		
		ExtractStockResponse response = new ExtractStockResponse();
		
		// TODO refactor
		if (request == null || request.getStockCode() == null || request.getStockCode().isEmpty() == true) {
			response.setStatus(ResponseStatus.ERROR);
			return response;
		} else {
			String stockCode = request.getStockCode();
			String stockFullName = StockDataImporter.getStockFullName(stockCode);
			response.setFullName(stockFullName);
			return response;
		}
	}

	

}
