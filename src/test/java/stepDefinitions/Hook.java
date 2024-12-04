package stepDefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;

public class Hook {

    @Before
    public void initializeActor() throws IOException {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }
}
