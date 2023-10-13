package ru.mpei.lec11;

import lombok.Data;

@Data
public class RegulatorCfg {
    private RegulatorInfo regulatorInfo;
    private double minQ;
    private double maxQ;
    private Coefs coefs;
}
