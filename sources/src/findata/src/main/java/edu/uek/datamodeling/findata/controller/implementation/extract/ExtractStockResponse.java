package edu.uek.datamodeling.findata.controller.implementation.extract;

import edu.uek.datamodeling.findata.controller.implementation.Response;

public class ExtractStockResponse extends Response {

	private String fullName;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
