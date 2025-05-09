
package dev.rme.model.wsdl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="item"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="promotionDisplays" type="{http://example.com/soap/model}promotionDisplay" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="shopName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="couponPrice" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="multiLanguageInfo" type="{http://example.com/soap/model}multiLanguageInfo"/&gt;
 *         &lt;element name="inventory" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mainImageUrl" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tags" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
    "itemId",
    "price",
    "promotionDisplays",
    "shopName",
    "couponPrice",
    "multiLanguageInfo",
    "inventory",
    "title",
    "mainImageUrl",
    "tags"
})
public class Item {

    protected long itemId;
    @XmlElement(required = true)
    protected String price;
    protected List<PromotionDisplay> promotionDisplays;
    @XmlElement(required = true)
    protected String shopName;
    @XmlElement(required = true)
    protected String couponPrice;
    @XmlElement(required = true)
    protected MultiLanguageInfo multiLanguageInfo;
    @XmlElement(required = true)
    protected BigInteger inventory;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String mainImageUrl;
    protected List<String> tags;

    /**
     * Gets the value of the itemId property.
     * 
     */
    public long getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     */
    public void setItemId(long value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrice(String value) {
        this.price = value;
    }

    /**
     * Gets the value of the promotionDisplays property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promotionDisplays property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromotionDisplays().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PromotionDisplay }
     * 
     * 
     */
    public List<PromotionDisplay> getPromotionDisplays() {
        if (promotionDisplays == null) {
            promotionDisplays = new ArrayList<>();
        }
        return this.promotionDisplays;
    }

    /**
     * Gets the value of the shopName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * Sets the value of the shopName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShopName(String value) {
        this.shopName = value;
    }

    /**
     * Gets the value of the couponPrice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCouponPrice() {
        return couponPrice;
    }

    /**
     * Sets the value of the couponPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCouponPrice(String value) {
        this.couponPrice = value;
    }

    /**
     * Gets the value of the multiLanguageInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MultiLanguageInfo }
     *     
     */
    public MultiLanguageInfo getMultiLanguageInfo() {
        return multiLanguageInfo;
    }

    /**
     * Sets the value of the multiLanguageInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiLanguageInfo }
     *     
     */
    public void setMultiLanguageInfo(MultiLanguageInfo value) {
        this.multiLanguageInfo = value;
    }

    /**
     * Gets the value of the inventory property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInventory() {
        return inventory;
    }

    /**
     * Sets the value of the inventory property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInventory(BigInteger value) {
        this.inventory = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the mainImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainImageUrl() {
        return mainImageUrl;
    }

    /**
     * Sets the value of the mainImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainImageUrl(String value) {
        this.mainImageUrl = value;
    }

    /**
     * Gets the value of the tags property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tags property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTags().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTags() {
        if (tags == null) {
            tags = new ArrayList<>();
        }
        return this.tags;
    }

}
