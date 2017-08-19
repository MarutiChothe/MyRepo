package org.barclays.service.cardstmtsvc.impl;

import javax.jws.WebService;

import org.barclays.cardstmttxnsvc.CardStmtTxnSvc;
import org.barclays.process.cardstmtsvc.impl.CardStmtSvcProcess;
import org.barclays.process.cardstmtsvc.util.CardStmtSvcSpringBeanLoader;
import org.barclays.process.cardstmtsvc.valuebeans.CardStmtSvcProcessVBReq;
import org.barclays.process.cardstmtsvc.valuebeans.CardStmtSvcProcessVBRes;
import org.barclays.schema.cardstmtsvc.req.CardStmtSvcReq;
import org.barclays.schema.cardstmtsvc.resp.CardStmtSvcRespType;
import org.barclays.schema.cardstmtsvc.resp.ResponseStatustype;
import org.barclays.service.cardstmtsvc.builders.CardStmtSvcReqBuilder;
import org.barclays.service.cardstmtsvc.builders.CardStmtSvcResBuilder;
import org.barclays.service.cardstmtsvc.util.CardStmtTxnSvcReqValidException;
import org.barclays.service.cardstmtsvc.validator.CardStmtSvcValidator;
import org.springframework.beans.factory.annotation.Autowired;

@WebService(endpointInterface="org.barclays.cardstmttxnsvc.CardStmtTxnSvc")
public class CardStmtSvcImpl implements CardStmtTxnSvc {
	
	@Autowired
	CardStmtSvcValidator validator;
	@Autowired
	CardStmtSvcReqBuilder reqBuilder;
	@Autowired
	CardStmtSvcProcess process;
	@Autowired
	CardStmtSvcResBuilder respbuilder;
	public CardStmtSvcRespType getCardTxnDetails(CardStmtSvcReq wsReq) {

		System.out.println("**Enterd into Svcimpl**");
		CardStmtSvcRespType wsResp = new CardStmtSvcRespType();

		try {
			// 1. Validate the request
			 validator = new CardStmtSvcValidator();
	
		
		validator.validateWSReq(wsReq);
			//2. Build the Request for process layer
	 reqBuilder = new CardStmtSvcReqBuilder();
				
			CardStmtSvcProcessVBReq vbReq  = reqBuilder.buildVBReq(wsReq);
			// 3. call the process layer and
			//get the response from process layer
	 process = new CardStmtSvcProcessImpl();
	
	CardStmtSvcProcessVBRes vbResp = process.getCardTxnDetails(vbReq);
			
			//4. Build the WSResponse 
			 respbuilder = new CardStmtSvcResBuilder();
			wsResp = respbuilder.buildWSResp(vbResp);
			
		} catch (CardStmtTxnSvcReqValidException e) {
			ResponseStatustype statustype = new ResponseStatustype();
			statustype.setRespCode(e.getErrorCode());
			statustype.setRespmsg(e.getErrorMsg());
			wsResp.setResponseStatus(statustype);
		}
		System.out.println("**Exit into Svcimpl**");		
		return wsResp;
	}

}
