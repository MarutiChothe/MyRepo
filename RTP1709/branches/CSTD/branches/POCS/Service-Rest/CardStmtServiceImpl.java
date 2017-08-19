package org.barclays.service.cardstmtsvc.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

//@WebService(endpointInterface="org.barclays.cardstmttxnsvc.CardStmtTxnSvc")
@Path("/cardInfo")
public class CardStmtServiceImpl {

	public CardStmtServiceImpl() {
		System.out.println("Constructor :CardStmtServiceImpl");
	}

	@Path("/txn/v1")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CardStmtSvcResp getTxnDtls(@QueryParam("clientID") String clientID,
			@QueryParam("channelID") String channelID,
			@QueryParam("cardNUmber") String cardNumber,
			@QueryParam("cvvNum") String cvvNum,
			@HeaderParam("patrkey") String patrkey) {

		System.out.println("ptrkey is :" + patrkey);

		System.out.println("Entered into CardStmtServiceImpl ");

		CardStmtSvcResp wsResp = new CardStmtSvcResp();

		ResponseStatus respStatus = new ResponseStatus();
		respStatus.setRespCode("0000");
		respStatus.setRespmsg("SUCCESS");

		wsResp.setResponseStatus(respStatus);
		Transactions transaction = new Transactions();

		wsResp.setTransactions(transaction);

		return wsResp;

	}

	@Path("/txndetail/v2")
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public CardStmtSvcResp getCardTxnDetails(CardStmtSvcReq svcReq,
			@Context HttpHeaders headers) {
		for(String header : headers.getRequestHeaders().keySet()){
			System.out.println("Header Names :"+header);
	        System.out.println("Header Value is :"+
			headers.getRequestHeader(header).get(0));
			
		}

		CardStmtSvcResp wsResp = new CardStmtSvcResp();
		ResponseStatus respStatus = new ResponseStatus();
		respStatus.setRespCode("0000");
		respStatus.setRespmsg("SUCCESS");

		Transactions transaction = new Transactions();

		List<Transaction> transList = transaction.getTransaction();
		Transaction txn = new Transaction();
		txn.setDescription("Good");
		txn.setAmount(254423);
		txn.setTxnType("CREDIT");
		txn.setVendor("LIFE STYLE");
		transList.add(txn);

		wsResp.setResponseStatus(respStatus);
		wsResp.setTransactions(transaction);

		return wsResp;
	}

	

}
