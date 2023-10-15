package ru.mpei.lec11;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<RegulatorCfg> parse = XmlUtils.parse("src/main/resources/config.xml", RegulatorCfg.class);
        System.out.println(parse.get());
        String code = JsonUtils.code(parse.get());
        System.out.println(code);


//        XmlUtils.marshal(parse.get(), "src/main/resources/generatedCfg.xml");
//
//        RegulatorCfg regulatorCfg = XmlSerialization.unMarshalAny(RegulatorCfg.class, "src/main/resources/config.xml");
//        System.out.println(regulatorCfg);
    }

}
