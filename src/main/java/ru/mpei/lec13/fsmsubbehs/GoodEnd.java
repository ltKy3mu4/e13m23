package ru.mpei.lec13.fsmsubbehs;

import jade.core.behaviours.OneShotBehaviour;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoodEnd extends OneShotBehaviour {
    @Override
    public void action() {
        log.info("GOOOD");
    }
}
