
package dev.rme.model.wsdl;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for promotionDisplay complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="promotionDisplay"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="promotionInfoList" type="{http://example.com/soap/model}promotionInfo" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "promotionDisplay", propOrder = {
    "typeName",
    "promotionInfoList"
})
public class PromotionDisplay {

    @XmlElement(required = true)
    protected String typeName;
    protected List<PromotionInfo> promotionInfoList;

    /**
     * Gets the value of the typeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Gets the value of the promotionInfoList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promotionInfoList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromotionInfoList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionInfo }
     * 
     * 
     */
    public List<PromotionInfo> getPromotionInfoList() {
        if (promotionInfoList == null) {
            promotionInfoList = new ArrayList<PromotionInfo>();
        }
        return this.promotionInfoList;
    }

}
