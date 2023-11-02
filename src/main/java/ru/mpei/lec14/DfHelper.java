package ru.mpei.lec14;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

import java.util.Arrays;
import java.util.List;

public class DfHelper {
    private DfHelper(){};

    public static List<AID> search(Agent a, String service) {
        DFAgentDescription dfAgentDescription = new DFAgentDescription();
        ServiceDescription searchingService = new ServiceDescription();
        searchingService.setType(service);
        dfAgentDescription.addServices(searchingService);

        try {
            DFAgentDescription[] search = DFService.search(a, dfAgentDescription);
            return Arrays.stream(search).map(e -> e.getName()).toList();
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
    }

    public static void register(Agent a, String service){
        DFAgentDescription dfad = new DFAgentDescription();
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setType(service);
        serviceDescription.setName(a.getLocalName());
        dfad.addServices(serviceDescription);

        try {
            DFService.register(a, dfad);
        } catch (FIPAException e) {
            throw new RuntimeException(e);
        }
    }


}
