package com.mock.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito.Then;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.mock.test.b.B;
import com.mock.test.b.BReq;
import com.mock.test.b.BResp;

public class ATest {

	A a;
	B b;
	@Before
	public void setUp() throws Exception {
		
		
		b = Mockito.mock(B.class);
		a = new A(b);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		System.out.println("mock object");
		Mockito.when(b.buildMockBObject(Matchers.any(BReq.class))).thenReturn(buildBreq());
		
		
		AResp aResp = a.buildMockObject(testbuildAMockObject());
		
		assertEquals("11111",aResp.getErrorCode());
		
	}

	private BResp buildBreq() {
		BResp bResp = new BResp();
		bResp.setErrorCode("11111");
		bResp.setErrormsg("fake mock object to check our dependent class object");
		return bResp;
	}

	private AReq testbuildAMockObject() {
		
		AReq aReq = new AReq();
		aReq.setCardName("jab tak aana tu hai mera salman khan");
		aReq.setCardNumber(123244656);
		return aReq;
	}

}
