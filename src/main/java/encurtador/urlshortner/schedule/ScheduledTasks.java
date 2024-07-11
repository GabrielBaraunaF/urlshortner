package encurtador.urlshortner.schedule;

import encurtador.urlshortner.service.Urlservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {

    @Autowired
    private Urlservice urlservice;

    @Scheduled(fixedDelay = 1,timeUnit = TimeUnit.MINUTES)
    public void runTasks() {
        urlservice.deleteUrl();
    }
}
