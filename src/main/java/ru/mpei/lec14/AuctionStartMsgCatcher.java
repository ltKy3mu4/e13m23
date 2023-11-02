package ru.mpei.lec14;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AuctionStartMsgCatcher extends Behaviour {
    private final double  myMinPrice;

    public AuctionStartMsgCatcher(double myMinPrice) {
        this.myMinPrice = myMinPrice;
    }

    @Override
    public void action() {
        ACLMessage auction = myAgent.receive(MessageTemplate.MatchProtocol("Auction"));
        if (auction != null){
            this.myAgent.addBehaviour(new SellerBehaviour(auction.getContent(), myMinPrice));
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
