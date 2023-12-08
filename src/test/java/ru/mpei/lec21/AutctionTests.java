package ru.mpei.lec21;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.mpei.kit.MasStarterKit;
import ru.mpei.lec14.AuctionStartMsgCatcher;
import ru.mpei.lec14.DfHelper;
import ru.mpei.lec14.StartAuction;

import java.util.List;

public class AutctionTests {
    private MasStarterKit kit = new MasStarterKit();
    @Test
    @SneakyThrows
    void successfulAuction(){
        kit.startJade(List.of("jade.core.messaging.TopicManagementService"));
        Behaviour buyerBehavior = createBuyerBehavior(100);
        kit.createAgent("AgentBuyer",buyerBehavior);
        AuctionStartMsgCatcher fSellerBeh = new AuctionStartMsgCatcher(20);
        kit.createAgent("TestAgen2", registerInDf("selling_books"), fSellerBeh);
        kit.createAgent("TestAgen3", registerInDf("selling_books"),new AuctionStartMsgCatcher(30));


        Thread.sleep(3000);

        Assertions.assertEquals(2, fSellerBeh.onEnd());
    }

    private Behaviour registerInDf(String serviceToReg){
        return new OneShotBehaviour() {
            @Override
            public void action() {
                DfHelper.register(this.getAgent(), serviceToReg);
            }
        };
    }

    private Behaviour createBuyerBehavior(long delayToStart){
        return new OneShotBehaviour(){
            Behaviour subBeh;
            @Override
            public void action() {
                subBeh = new StartAuction(this.getAgent(), delayToStart);
                getAgent().addBehaviour(subBeh);
            }

            @Override
            public int onEnd() {
                return subBeh.onEnd();
            }
        };
    }

}
