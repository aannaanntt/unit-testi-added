package com.hotel.booking.customexception;

public class ControllerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String desc;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ControllerException(String errorCode, String desc) {
		super();
		this.errorCode = errorCode;
		this.desc = desc;
	}

	public ControllerException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ControllerException() {
		// TODO Auto-generated constructor stub
	}
}
