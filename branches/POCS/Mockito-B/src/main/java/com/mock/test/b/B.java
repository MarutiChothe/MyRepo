package com.mock.test.b;

public class B {
	
	public BResp buildMockBObject(BReq bReq){
		
		System.out.println("B object");
		
		BResp bResp = new BResp();
		bResp.setErrorCode("00000");
		bResp.setErrormsg("job apply is valid");
		
		return bResp;
		
	}

}
