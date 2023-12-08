package ru.mpei.lec14;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuctionStartMsgCatcher extends Behaviour {
    private final double  myMinPrice;

    public AuctionStartMsgCatcher(double myMinPrice) {
        this.myMinPrice = myMinPrice;
    }

    @Override
    public void onStart() {
        log.info("Started behaviour to receive cfp");
    }

    @Override
    public void action() {
        ACLMessage auction = myAgent.receive(MessageTemplate.MatchProtocol("Auction"));
        if (auction != null){
            log.info("received invite");
            this.myAgent.addBehaviour(new SellerBehaviour(auction.getContent(), myMinPrice));
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }

    @Override
    public int onEnd() {
        return 2;
    }
}
