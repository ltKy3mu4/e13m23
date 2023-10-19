package ru.mpei.lec12;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Date;

public class DelayedMsgSendingBehaviour extends WakerBehaviour {
    public DelayedMsgSendingBehaviour(Agent a, long wakeupTime) {
        super(a, wakeupTime);
    }

    @Override
    protected void onWake() {
        ACLMessage m =new ACLMessage(ACLMessage.CFP);
        m.setContent("hello");
        m.addReceiver(new AID("Stepan", false));
        myAgent.send(m);
        System.out.println(myAgent.getLocalName()+" - sent msg");
    }
}
