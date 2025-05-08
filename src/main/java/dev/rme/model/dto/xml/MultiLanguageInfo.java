package dev.rme.model.dto.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class MultiLanguageInfo {
    public String language;
    public String title;

    @XmlTransient
    public String getLanguage() {
        return language;
    }

    @XmlTransient
    public String getTitle() {
        return title;
    }
}
