package pack.mock.power.a;

public class AResp {
	
	private String respcode;
	private String respmsg;
	

	public String getRespcode() {
		return respcode;
	}
	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}
	public String getRespmsg() {
		return respmsg;
	}
	public void setRespmsg(String respmsg) {
		this.respmsg = respmsg;
	}
	@Override
	public String toString() {
		return "B [respcode=" + respcode + ", respmsg=" + respmsg + "]";
	}
	


}
