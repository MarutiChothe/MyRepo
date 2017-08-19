
package org.barclays.service.cardstmtsvc.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.barclays.schema.cardstmtsvc.req package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CardStmtSvcReq_QNAME = new QName("http://www.barclays.org/schema/Cardstmtsvc/req", "CardStmtSvcReq");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.barclays.schema.cardstmtsvc.req
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClientInfo }
     * 
     */
    public ClientInfo createClientInfo() {
        return new ClientInfo();
    }

    /**
     * Create an instance of {@link CustomerDetails }
     * 
     */
    public CustomerDetails createCustomerDetails() {
        return new CustomerDetails();
    }

    /**
     * Create an instance of {@link CardStmtSvcReq }
     * 
     */
    public CardStmtSvcReq createCardStmtSvcReq() {
        return new CardStmtSvcReq();
    }

    /**
     * Create an instance of {@link ServiceDetails }
     * 
     */
    public ServiceDetails createServiceDetails() {
        return new ServiceDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CardStmtSvcReq }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.barclays.org/schema/Cardstmtsvc/req", name = "CardStmtSvcReq")
    public JAXBElement<CardStmtSvcReq> createCardStmtSvcReq(CardStmtSvcReq value) {
        return new JAXBElement<CardStmtSvcReq>(_CardStmtSvcReq_QNAME, CardStmtSvcReq.class, null, value);
    }

}
