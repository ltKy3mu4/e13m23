package ru.mpei.lec13.fsmsubbehs;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class WaitForAnswersParallelBaehaviour extends ParallelBehaviour {

    private int participantsCount;
    private Behaviour wakeupBeh;
    private ReceiveAnswersSubBeh receiveBeh;

    public WaitForAnswersParallelBaehaviour(int participantsCount) {
        super(WHEN_ANY);
        this.participantsCount = participantsCount;
    }

    @Override
    public void onStart() {
        receiveBeh = new ReceiveAnswersSubBeh(participantsCount);
        wakeupBeh = new WakerBehaviour(myAgent, 5000){
            boolean wake = false;
            @Override
            protected void onWake() {
                wake = true;
                log.info("TIME IS UP");
            }

            @Override
            public int onEnd() {
                return wake ? 1 : 2;
            }
        };
        this.addSubBehaviour(receiveBeh);
        this.addSubBehaviour(wakeupBeh);
    }

    @Override
    public int onEnd() {
        //badway == 1, good way == 2;
        if (receiveBeh.done()) {
            if (receiveBeh.onEnd() == 1) {
                log.info("No appropriate offer was received");
                return 1;
            } else {
                log.info("There is a winner");
                return 2;
            }
        } else {
            if (receiveBeh.getBestOffer() != null) {
                log.info("There is a winner");
                return  2;
            } else {
                log.info("No appropriate offer was received");
                return 1;
            }
        }
     }
}
