package ru.mpei.kit;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.Behaviour;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import lombok.SneakyThrows;
import ru.mpei.lec14.AgentBuyer;
import ru.mpei.lec14.AgentSeller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MasStarterKit {
    private AgentContainer mainContainer;

    public void startJade(List<String> services) {
        Properties props = new Properties();
        props.setProperty("gui", "true");
        props.setProperty("services", addServices(services));
        ProfileImpl p = new ProfileImpl(props);
        Runtime.instance().setCloseVM(true);
        mainContainer = Runtime.instance().createMainContainer(p);
    }

    public void startJade() {
        this.startJade(Collections.emptyList());
    }

    @SneakyThrows
    public void createAgent(String agentName, Behaviour... beh){
        AgentController newAgent = mainContainer.createNewAgent(agentName, AgentTester.class.getName(), beh);
        newAgent.start();
    }

    private String addServices(List<String> services) {
        String outString ="";
        for (String service : services) {
            outString+=service+";";
        }
        return outString;
    }

}
