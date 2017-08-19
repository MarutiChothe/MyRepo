
package org.barclays.service.cardstmtsvc.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardStmtSvcReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardStmtSvcReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientInfo" type="{http://www.barclays.org/schema/Cardstmtsvc/req}ClientInfo"/>
 *         &lt;element name="CustomerDetails" type="{http://www.barclays.org/schema/Cardstmtsvc/req}CustomerDetails"/>
 *         &lt;element name="ServiceDetails" type="{http://www.barclays.org/schema/Cardstmtsvc/req}ServiceDetails"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardStmtSvcReq", propOrder = {
    "clientInfo",
    "customerDetails",
    "serviceDetails"
})
@XmlRootElement
public class CardStmtSvcReq {

    @XmlElement(name = "ClientInfo", required = true)
    protected ClientInfo clientInfo;
    @XmlElement(name = "CustomerDetails", required = true)
    protected CustomerDetails customerDetails;
    @XmlElement(name = "ServiceDetails", required = true)
    protected ServiceDetails serviceDetails;

    /**
     * Gets the value of the clientInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ClientInfo }
     *     
     */
    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    /**
     * Sets the value of the clientInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClientInfo }
     *     
     */
    public void setClientInfo(ClientInfo value) {
        this.clientInfo = value;
    }

    /**
     * Gets the value of the customerDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerDetails }
     *     
     */
    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    /**
     * Sets the value of the customerDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerDetails }
     *     
     */
    public void setCustomerDetails(CustomerDetails value) {
        this.customerDetails = value;
    }

    /**
     * Gets the value of the serviceDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDetails }
     *     
     */
    public ServiceDetails getServiceDetails() {
        return serviceDetails;
    }

    /**
     * Sets the value of the serviceDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDetails }
     *     
     */
    public void setServiceDetails(ServiceDetails value) {
        this.serviceDetails = value;
    }

}
