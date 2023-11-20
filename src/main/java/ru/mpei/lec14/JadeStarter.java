package ru.mpei.lec14;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;

import java.util.List;
import java.util.Map;

public class JadeStarter {
    public static void main(String[] args) {
        Map<String, Class<?>> agents = Map.of(
                "buyer", AgentBuyer.class,
                "seller1", AgentSeller.class,
                "seller2", AgentSeller.class
        );
        ProfileImpl p = createProperties(agents);
        startPlatfrom(p);
    }

    private static void startPlatfrom(ProfileImpl p) {
        Runtime.instance().setCloseVM(true);
        Runtime.instance().createMainContainer(p);
    }

    private static ProfileImpl createProperties(Map<String, Class<?>> agents) {
        Properties props = new ExtendedProperties();
        props.setProperty("gui", "true");
        props.setProperty("agents", addAgents(agents));
        props.setProperty("services", addServices(List.of("jade.core.messaging.TopicManagementService")));
        ProfileImpl p = new ProfileImpl(props);
        return p;
    }

    private static String addAgents(Map<String, Class<?>> createAgents){
        String outString = "";
        for (Map.Entry<String, Class<?>> entry : createAgents.entrySet()) {
            outString += entry.getKey()+":"+entry.getValue().getName()+";";
        }
        System.out.println(outString);
        return outString;
    }

    private static String addServices(List<String> services) {
        String outString ="";
        for (String service : services) {
            outString+=service+";";
        }
        return outString;
    }
}
