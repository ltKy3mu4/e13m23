package ru.mpei.lec12;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class ReceiveMsgBehaviour extends Behaviour {
    private boolean msgReceived = false;

    @Override
    public void onStart() {
        System.out.println("I'm waiting for msg");
    }

    @Override
    public void action() {
        //Message template = msg filter
        ACLMessage receive = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.CFP));
        if (receive != null){
            System.out.println(myAgent.getLocalName()+" - i received MSG "+receive.getContent());
//            msgReceived = true;
        } else {
            block();
        }

    }

    @Override
    public boolean done() {
        return msgReceived;
    }
}
