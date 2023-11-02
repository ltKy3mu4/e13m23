package ru.mpei.lec14;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class AgentSeller extends Agent {

    @Override
    protected void setup() {
        DfHelper.register(this, "selling_books");
        double minPrice = new Random().nextDouble() * 10 + 10;
        log.info("My min price {}", minPrice);
        this.addBehaviour(new AuctionStartMsgCatcher(minPrice));
    }
}
