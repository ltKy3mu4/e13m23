package ru.mpei.lec17;

import org.pcap4j.core.PcapHandle;
import ru.mpei.lec16.RawUdpSocketServer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RawUdpSocketServerBasedOnExecutor extends RawUdpSocketServer {
    private ScheduledExecutorService es;
    public RawUdpSocketServerBasedOnExecutor(ScheduledExecutorService es) {
        this.es = es;
    }

    @Override
    protected void runInThread(PcapHandle pcapHandle) {
        es.schedule(() -> this.grabPackets(pcapHandle), 0, TimeUnit.MILLISECONDS);
    }

    public void stopServer(){
        this.run = false;
    }
}
