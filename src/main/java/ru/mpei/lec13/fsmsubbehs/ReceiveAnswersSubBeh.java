package ru.mpei.lec13.fsmsubbehs;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReceiveAnswersSubBeh extends Behaviour {
    private List<ACLMessage> answers = new ArrayList<>();
    private ACLMessage bestOffer = null;
    private Double bestPrice = null;
    private final int participantsCount;

    public ReceiveAnswersSubBeh(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    @Override
    public void action() {
        ACLMessage propose = myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.PROPOSE));
        if (propose != null) {
            answers.add(propose);
            String stringPrice = propose.getContent();
            double price = -1;
            try {
                price = Double.parseDouble(stringPrice);
            } catch (NumberFormatException e) {
                log.warn("Received bad price msg from {}", propose.getSender().getLocalName());
            }
            if (price > 0 && (bestPrice == null || price < bestPrice)) {
                bestPrice = price;
                bestOffer = propose;
            }
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return participantsCount == answers.size();
    }

    @Override
    public int onEnd() {
        return bestOffer == null ? 1 : 2;
    }

    public ACLMessage getBestOffer() {
        return bestOffer;
    }
}
