package pack.mock.power.a;

import pack.power.mockito.b.B;
import pack.power.mockito.b.BReq;
import pack.power.mockito.b.BResp;

public class A {

	B b = new B();


	 

	public AResp buildA(AReq aReq){

		aReq.setAge(24);
		aReq.setName("maruti");

		BReq bReq = new BReq();
		bReq.setAge(aReq.getAge());
		bReq.setName(aReq.getName());

		BResp bResp = b.buildB(bReq);

		AResp aResp = new AResp();
		aResp.setRespcode(bResp.getRespcode());
		aResp.setRespmsg(bResp.getRespmsg());	

		return aResp;

	}

}
