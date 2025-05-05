package dev.rme.model.dto;

import jakarta.xml.bind.annotation.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@XmlRootElement(name = "product")
public class Product {
    public Long itemId;
    public double price;
    public PromotionDisplay promotionDisplay;
    public String shopName;
    public double couponPrice;
    public MultiLanguageInfo multiLanguageInfo;
    public int inventory;
    public String title;
    public String mainImageUrl;

    @XmlTransient
    public Long getItemId() {
        return itemId;
    }

    @XmlTransient
    public double getPrice() {
        return price;
    }

    @XmlTransient
    public PromotionDisplay getPromotionDisplay() {
        return promotionDisplay;
    }

    @XmlTransient
    public String getShopName() {
        return shopName;
    }

    @XmlTransient
    public double getCouponPrice() {
        return couponPrice;
    }

    @XmlTransient
    public MultiLanguageInfo getMultiLanguageInfo() {
        return multiLanguageInfo;
    }

    @XmlTransient
    public int getInventory() {
        return inventory;
    }

    @XmlTransient
    public String getTitle() {
        return title;
    }

    @XmlTransient
    public String getMainImageUrl() {
        return mainImageUrl;
    }
}
