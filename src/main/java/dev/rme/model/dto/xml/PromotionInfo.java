package dev.rme.model.dto.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PromotionInfo {
    public String activityCode;
    public String promotionName;

    @XmlTransient
    public String getActivityCode() {
        return activityCode;
    }

    @XmlTransient
    public String getPromotionName() {
        return promotionName;
    }
}
