package ru.mpei.lec11;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Coefs {
    @XmlElement(name = "p")
    private double kP;
    @XmlElement(name = "i")
    private double kI;
    @XmlElement(name = "d")
    private double kD;
}
