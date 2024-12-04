package interactions;


import net.serenitybdd.model.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.concurrent.TimeUnit;

public class WaitMoment implements Interaction {

    private final long timeInMilliseconds;

    public WaitMoment(long timeInMilliseconds) {
        this.timeInMilliseconds = timeInMilliseconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(timeInMilliseconds);
    }

    public static WaitMoment pageInSeconds(long timeInMilliseconds){
        return Tasks.instrumented(WaitMoment.class, TimeUnit.SECONDS.toMillis(timeInMilliseconds));
    }
}
