package ru.mpei.lec13.fsmsubbehs;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.ArrayList;
import java.util.List;

public class SendInvites extends OneShotBehaviour {

    private List<String> agentNames;

    public SendInvites(List<String> agentNames) {
        this.agentNames = agentNames;
    }

    @Override
    public void action() {
        ACLMessage m = new ACLMessage(ACLMessage.CFP);

        agentNames.stream()
                .map(e -> new AID(e, false))
                .forEach(aid -> m.addReceiver(aid));
    }
}
