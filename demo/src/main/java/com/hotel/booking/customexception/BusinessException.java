package com.hotel.booking.customexception;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException {

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

	public BusinessException(String errorCode, String desc) {
		super();
		this.errorCode = errorCode;
		this.desc = desc;
	}

	public BusinessException() {

	}

}
