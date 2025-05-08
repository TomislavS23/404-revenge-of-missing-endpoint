
package dev.rme.model.generated;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for promotionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="promotionInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activityCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="promotionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "promotionInfo", propOrder = {
    "activityCode",
    "promotionName"
})
public class PromotionInfo {

    @XmlElement(required = true)
    protected String activityCode;
    @XmlElement(required = true)
    protected String promotionName;

    /**
     * Gets the value of the activityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityCode() {
        return activityCode;
    }

    /**
     * Sets the value of the activityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityCode(String value) {
        this.activityCode = value;
    }

    /**
     * Gets the value of the promotionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionName() {
        return promotionName;
    }

    /**
     * Sets the value of the promotionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionName(String value) {
        this.promotionName = value;
    }

}
