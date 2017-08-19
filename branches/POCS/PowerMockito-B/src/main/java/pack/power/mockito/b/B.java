package pack.power.mockito.b;

public class B {
	
	public BResp buildB(BReq bReq ){
		 
		//respflow 
		BResp bResp = new BResp();
		bResp.setRespcode("000000");
		bResp.setRespmsg("success B original data");
		return bResp ;
		
	}
	
	public B() {
		super();
	}
	

}
