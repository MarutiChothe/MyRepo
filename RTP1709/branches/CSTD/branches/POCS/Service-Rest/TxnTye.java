
package org.barclays.service.cardstmtsvc.impl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TxnTye.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TxnTye">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="DEBIT"/>
 *     &lt;enumeration value="BOTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TxnTye")
@XmlEnum
public enum TxnTye {

    CREDIT,
    DEBIT,
    BOTH;

    public String value() {
        return name();
    }

    public static TxnTye fromValue(String v) {
        return valueOf(v);
    }

}
