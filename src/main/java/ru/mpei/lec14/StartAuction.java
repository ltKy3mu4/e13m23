package ru.mpei.lec14;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public class StartAuction extends WakerBehaviour {

    public StartAuction(Agent a, long wakeupDate) {
        super(a, wakeupDate);
    }

    @Override
    protected void onWake() {
        var ags = DfHelper.search(myAgent, "selling_books");
        String topicName = "topic_"+new Random().nextLong(1000000000);
        TopicHelper.register(myAgent, topicName);
        ACLMessage msg =new ACLMessage(ACLMessage.PROPOSE);
        msg.setContent(topicName);
        msg.setProtocol("Auction");
        ags.forEach(e -> msg.addReceiver(e));
        myAgent.send(msg);
    }
}
