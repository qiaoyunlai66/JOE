//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.09 at 04:40:51 PM CST 
//


package net.sf.dynamicreports.report.defaults.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HorizontalAlignment.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HorizontalAlignment"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="LEFT"/&gt;
 *     &lt;enumeration value="CENTER"/&gt;
 *     &lt;enumeration value="RIGHT"/&gt;
 *     &lt;enumeration value="JUSTIFIED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "HorizontalAlignment")
@XmlEnum
public enum XmlHorizontalAlignment {

    LEFT,
    CENTER,
    RIGHT,
    JUSTIFIED;

    public String value() {
        return name();
    }

    public static XmlHorizontalAlignment fromValue(String v) {
        return valueOf(v);
    }

}
