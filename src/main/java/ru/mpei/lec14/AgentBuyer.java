package ru.mpei.lec14;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

public class AgentBuyer extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new StartAuction(this, 3000));


    }
}
