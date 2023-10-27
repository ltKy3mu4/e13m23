package ru.mpei.lec13;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParallelBeh extends ParallelBehaviour {

    public ParallelBeh() {
        super(WHEN_ANY);
    }
    private Behaviour receiveBeh, wakerBeh;

    @Override
    public void onStart() {
        receiveBeh = new ReceiveMsgBehaviour();
        this.addSubBehaviour(receiveBeh);
        wakerBeh = new TimeIsOverWakerBehaviour(myAgent, 15000);
        this.addSubBehaviour(wakerBeh);
    }

    @Override
    public int onEnd() {
        if (receiveBeh.done()){
            log.info("Required msgs were received");
        } else {
            log.info("Time is ip!!!!");
        }
        return 0;
    }
}
