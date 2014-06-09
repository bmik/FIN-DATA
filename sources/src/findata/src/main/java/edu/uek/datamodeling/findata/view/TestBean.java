package edu.uek.datamodeling.findata.view;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.uek.datamodeling.findata.controller.implementation.extract.ExtractStockRequest;
import edu.uek.datamodeling.findata.controller.implementation.extract.ExtractStockResponse;
import edu.uek.datamodeling.findata.controller.service.ExtractService;

@Controller("testBean")
@Scope("request")
public class TestBean implements Serializable {

	private static final long serialVersionUID = -5317413022036931996L;
	
	private static final Logger log = Logger.getLogger(TestBean.class);

	@Autowired
	private ExtractService extractService;
	

	public String getStockName(String stockCode) {
		ExtractStockRequest request = new ExtractStockRequest();
		request.setStockCode(stockCode);
		ExtractStockResponse response = extractService.extractStock(request);
		
		return response.getFullName();
	}
	
}
