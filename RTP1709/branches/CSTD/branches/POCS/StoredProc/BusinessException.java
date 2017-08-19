package com.hsbc.intg.customer.info.impl;

public class BusinessException extends Exception{
	private String responseCode;
	private String responseMessage;
public BusinessException(){
	super();
}
public BusinessException(String responseCode,String responseMessage){
	super();
	this.responseCode=responseCode;
	this.responseMessage=responseMessage;
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
