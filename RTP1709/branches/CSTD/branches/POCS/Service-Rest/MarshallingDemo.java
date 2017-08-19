/*@CopyRigh SreenuTech 2016.All Rights are reserved.We 
 *  should not disclose the information outiside.terms and
 *  Conditions will apply.
 * 
 */
package org.barclays.service.cardstmtsvc.impl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author stechrtp
 *
 * 25-Mar-2016
 */
public class MarshallingDemo {

	/**
	 * void
	 * @throws JAXBException 
	 */
	public static void main(String[] args) throws JAXBException {
		
		JAXBContext jcon = JAXBContext.newInstance("org.barclays.service.cardstmtsvc.impl");
		Marshaller marshller = jcon.createMarshaller();
		CardStmtSvcReq req = new CardStmtSvcReq();
		
		ClientInfo clientInfo = new ClientInfo();
		clientInfo.setChannelId("ONLINE");
		clientInfo.setClientId("WEB");
		clientInfo.setReqId("121212");
		req.setClientInfo(clientInfo );
		CustomerDetails custDtls = new CustomerDetails();
		custDtls.setCardName("SREENU");
		custDtls.setCardNumber("23432423432");
		custDtls.setSortCode("12");
		custDtls.setTxnTye(TxnTye.BOTH);
		
		
		req.setCustomerDetails(custDtls);
		
		marshller.marshal(req, System.out);
		

	}

}
