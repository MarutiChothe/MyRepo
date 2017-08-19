package com.mock.test;

public class AResp {
	
	private String errorCode;
	private String errormsg;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	@Override
	public String toString() {
		return "AResp [errorCode=" + errorCode + ", errormsg=" + errormsg + "]";
	}
	

}
