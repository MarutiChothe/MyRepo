package org.barclays.service.cardstmtsvc.impl;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.barclays.process.cardstmt.valuebeans.CardStmtSvcProcessVBReq;
import org.barclays.process.cardstmt.valuebeans.CardStmtSvcProcessVBResp;
import org.barclays.process.cardstmt.valuebeans.TransactionBean;
import org.barclays.process.cardstmt.valuebeans.TransactionsBean;
import org.barclays.process.cardstmtsvc.impl.CardStmtSvcProcessImpl;
import org.barclays.schema.cardstmtsvc.req.CardStmtTxnDetailsReqType;
import org.barclays.schema.cardstmtsvc.req.ClientInfoType;
import org.barclays.schema.cardstmtsvc.req.CustomerInfoType;
import org.barclays.schema.cardstmtsvc.req.ServiceDetailsType;
import org.barclays.schema.cardstmtsvc.res.CardStmtTxnDetailsRespType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;





@RunWith(PowerMockRunner.class)
@PrepareForTest({CardStmtServiceImpl.class,CardStmtSvcProcessImpl.class})
public class CardStmtServiceImplTest {
	
	
	
	CardStmtServiceImpl cardStmtSvcImpl = null;
	CardStmtSvcProcessImpl cardStmtSvcProcessImpl = null;
	CardStmtTxnDetailsRespType  wsResp = null;
	CardStmtTxnDetailsReqType wsReq = null;
	ClientInfoType clientInfo = null;
	CustomerInfoType custInfo = null;
	ServiceDetailsType serviceDtls = null;
	CardStmtSvcProcessVBResp vbResp =null;

	@Before
	public void setUp() throws Exception {
		cardStmtSvcImpl = new CardStmtServiceImpl();
		cardStmtSvcProcessImpl = new CardStmtSvcProcessImpl();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getStatementTxns() throws Exception {
		
		wsResp = new CardStmtTxnDetailsRespType();
		wsResp = cardStmtSvcImpl.getStatementTxns(wsReq);
		
		
		//POWERMOCKING OBJ CREATED FOR PROCESS IMPL CLASS 
		cardStmtSvcProcessImpl = PowerMockito.mock(CardStmtSvcProcessImpl.class);
		PowerMockito.whenNew(CardStmtSvcProcessImpl.class).withNoArguments().thenReturn(cardStmtSvcProcessImpl);
		
		
		wsReq = new CardStmtTxnDetailsReqType();
		vbResp = new CardStmtSvcProcessVBResp();
		buildvbResp();
		
		PowerMockito.when(cardStmtSvcProcessImpl.getCardTxnDtls(Matchers.any(CardStmtSvcProcessVBReq.class))).thenReturn(vbResp);
	
		buildwsReq();
	
		
		assertNotNull(wsReq);
		assertNotNull(vbResp);
		assertEquals("1112", vbResp.getErrorCode());
		assertEquals("123", wsReq.getClientInfo().getClientID());
//		assertEquals(3000.00, vbResp.get
		 
		
		
		
		
		
	}
	
	
	
	
	public void buildwsReq(){
		
		
		 //prepare wsReqobj
		
		wsReq = new CardStmtTxnDetailsReqType();
		 
		    clientInfo = new  ClientInfoType();
			custInfo = new CustomerInfoType();
			serviceDtls = new ServiceDetailsType();
			
			
			//preparing clientinfo obj
			clientInfo.setClientID("123");
			clientInfo.setChannelID("2345");
			clientInfo.setReqID("345");
			
			//preparing custinfo obj
			custInfo.setCustname("KOTI");
			custInfo.setCardNbr("345789766");
			custInfo.setSorcode("456789");
			
			
			
			//setting expdate
			Date d =null;
			  DateFormat df = new SimpleDateFormat("mm/yy");
			  try {
				d=df.parse("11/18");
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  GregorianCalendar gc =new GregorianCalendar();
			   gc.setTimeInMillis(d.getTime());
			   try {
				XMLGregorianCalendar xgc =  DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
				custInfo.setExpdate(xgc);
			} catch (DatatypeConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//setting startDate
			Date d1 =null;
			  DateFormat df1 = new SimpleDateFormat("yyyy/mm/dd");
			  try {
				d1=df1.parse("2011/11/23");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  GregorianCalendar gc1 =new GregorianCalendar();
			   gc.setTimeInMillis(d1.getTime());
			   try {
				XMLGregorianCalendar xgc1 =  DatatypeFactory.newInstance().newXMLGregorianCalendar(gc1);
				custInfo.setStartdate(xgc1);
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   //setting enddate
			   Date d2 =null;
				  DateFormat df2 = new SimpleDateFormat("yyyy/mm/dd");
				  try {
					d2=df2.parse("2011/11/23");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  GregorianCalendar gc2 =new GregorianCalendar();
				   gc2.setTimeInMillis(d.getTime());
				   try {
					XMLGregorianCalendar xgc2 =  DatatypeFactory.newInstance().newXMLGregorianCalendar(gc2);
					custInfo.setEnddate(xgc2);
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   
//			   custInfo.setTxnType(TxnTye.CREDIT);
				   
			   //preparing serviceDtls obj
				   serviceDtls.setServiceName("12");
				   serviceDtls.setMethodname("getTxn");
				   serviceDtls.setVersion("1.2");
				   
				   //set objs to wsreq
				   wsReq.setClientInfo(clientInfo);
				   wsReq.setCustomerInfo(custInfo);
				   wsReq.setServiceDetails(serviceDtls);
		 
	} 
	
	
	
	 public void buildvbResp(){
			
			vbResp.setErrorCode("1111");
			vbResp.setErrormsg("SUCESS");
			
			//process layer transcationbean
			TransactionsBean transactionsBean = new TransactionsBean();
			List <TransactionBean> transactionBeanList = new ArrayList<TransactionBean>();
			TransactionBean  transaction1 = new TransactionBean();
			  
			  transaction1.setAmt(20000.00);
			  transaction1.setDescription("TV");
			  transaction1.setVendor("HYD-PVR");
			  transaction1.setStatus("SUCESS");
			  transaction1.setTransId(24567896);
			  transaction1.setType("CREDIT");
			
			transactionBeanList.add(transaction1);
			transactionsBean.setTransactionBean(transactionBeanList);
			
			vbResp.setTransactionsBean(transactionsBean);
			
		  }

	
	
	
}
