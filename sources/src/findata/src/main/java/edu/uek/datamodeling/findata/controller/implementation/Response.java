package edu.uek.datamodeling.findata.controller.implementation;

import edu.uek.datamodeling.findata.controller.implementation.enums.ResponseStatus;

// TODO: Auto-generated Javadoc
/**
 * The Class Response.
 */
public abstract class Response {

	/** The status. */
	private ResponseStatus status;
	
	/** The desc. */
	private String desc;

	/**
	 * Gets the desc.
	 *
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the desc.
	 *
	 * @param desc the new desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ResponseStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}
	
}
