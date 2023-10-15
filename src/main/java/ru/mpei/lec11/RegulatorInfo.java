package ru.mpei.lec11;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class RegulatorInfo {
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "ver")
    private String version;
}
