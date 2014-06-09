package edu.uek.datamodeling.findata.controller.implementation;

import edu.uek.datamodeling.findata.controller.implementation.enums.ResponseStatus;

public abstract class Response {

	private ResponseStatus status;
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	
}
