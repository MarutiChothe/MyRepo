package com.hsbc.intg.customer.info.impl;

public class SystemException extends Exception{
	private String responseCode;
	
	private String responseMessage;
//	public SystemException(){
//		super();
//	}
	public SystemException(String statusCode,String statusMessage){
		super();
		this.responseCode=statusCode;
		this.responseMessage=statusMessage;
	}
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}
	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

}
