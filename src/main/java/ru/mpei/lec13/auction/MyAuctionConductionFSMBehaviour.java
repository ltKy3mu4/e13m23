package ru.mpei.lec13.auction;

import jade.core.AID;
import jade.core.behaviours.FSMBehaviour;
import ru.mpei.lec13.fsmsubbehs.BadEnd;
import ru.mpei.lec13.fsmsubbehs.GoodEnd;
import ru.mpei.lec13.fsmsubbehs.SendInvites;
import ru.mpei.lec13.fsmsubbehs.WaitForAnswersParallelBaehaviour;

import java.util.ArrayList;
import java.util.List;

public class MyAuctionConductionFSMBehaviour extends FSMBehaviour {
    private static final String FIRST_STATE="firstState", WAIT_PROPOSES ="waitProps", GOOD_END="goodEnd", BAD_END ="badEnd";

    @Override
    public void onStart() {
        //TODO: fill it with DF results
         List<String> receivers = List.of("Agent2");
         this.registerFirstState(new SendInvites(receivers), FIRST_STATE);
         this.registerState(new WaitForAnswersParallelBaehaviour(receivers.size()), WAIT_PROPOSES);
         this.registerLastState(new GoodEnd(),GOOD_END);
         this.registerLastState(new BadEnd(), BAD_END);

         this.registerDefaultTransition(FIRST_STATE, WAIT_PROPOSES);
         this.registerTransition(WAIT_PROPOSES, BAD_END, 1);
         this.registerTransition(WAIT_PROPOSES, GOOD_END, 2);
    }
}
