package dev.rme.model.xml;

import jakarta.xml.bind.annotation.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PromotionDisplay {
    private String typeName;
    @XmlElementWrapper(name = "promotionInfoList")
    @XmlElement(name = "promotionInfo")
    private List<PromotionInfo> promotionInfoList;

    @XmlTransient
    public String getTypeName() {
        return typeName;
    }

    @XmlTransient
    public List<PromotionInfo> getPromotionInfoList() {
        return promotionInfoList;
    }
}
