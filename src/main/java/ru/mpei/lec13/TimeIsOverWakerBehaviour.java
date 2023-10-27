package ru.mpei.lec13;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class TimeIsOverWakerBehaviour extends WakerBehaviour {
    public TimeIsOverWakerBehaviour(Agent a, long wakeupDate) {
        super(a, wakeupDate);
    }

    @Override
    protected void onWake() {
        log.warn("Time is up");
    }
}
