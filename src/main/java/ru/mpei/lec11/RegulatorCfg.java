package ru.mpei.lec11;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@XmlRootElement(name = "cfg")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegulatorCfg {
    @XmlElement(name = "info")
//    @JsonProperty(value = "info")
    private RegulatorInfo regulatorInfo;
    @XmlElement
    private double minQ;
    @XmlElement
    private double maxQ;
    @XmlElement(name = "coefficients")
    private Coefs coefs;
}
