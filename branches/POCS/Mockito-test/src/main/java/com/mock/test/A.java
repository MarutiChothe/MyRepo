package com.mock.test;

import com.mock.test.b.B;
import com.mock.test.b.BReq;
import com.mock.test.b.BResp;

public class A {
	
	B b;

	public A(B b) {
		super();
		this.b = b;
	}
	
	
	public AResp buildMockObject(AReq aReq){
		//  B b= new B();
		 BReq bReq = new BReq();
		 aReq.setCardName("arjun");
		 aReq.setCardNumber(12364);
		 bReq.setCardName(aReq.getCardName());
		 bReq.setCardNumber(aReq.getCardNumber());
		 BResp bResp = b.buildMockBObject(bReq);
		
		AResp aResp = new AResp();
		aResp.setErrorCode(bResp.getErrorCode());
		aResp.setErrormsg(bResp.getErrormsg());
		 
		return aResp ;
		
	}

}
