package pack.mock.power.a;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import pack.power.mockito.b.B;
import pack.power.mockito.b.BReq;
import pack.power.mockito.b.BResp;

@RunWith(PowerMockRunner.class)
@PrepareForTest({A.class,B.class})
public class ATest {

	A a;
	B b;
	
	@Before
	public void setUp() throws Exception {
		
		b=PowerMockito.mock(B.class);
		PowerMockito.whenNew(B.class).withNoArguments().thenReturn(b);
		a = new A();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		PowerMockito.when(b.buildB(Matchers.any(BReq.class)))
		.thenReturn(buildBReq());
         
		AResp aResp = a.buildA(testbuildA());
		
		assertEquals("11111",aResp.getRespcode());
		
	}

	private BResp buildBReq() {
		
		BResp bResp = new BResp();
		bResp.setRespcode("11111");
		bResp.setRespmsg("unique result set by mock");
		
		return bResp;
	}

	private AReq testbuildA() {
		AReq aReq = new AReq();
		aReq.setAge(35);
		aReq.setName("tiger");
		return aReq;
	}

}
