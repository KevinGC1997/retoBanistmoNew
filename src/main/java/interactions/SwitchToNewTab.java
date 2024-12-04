package interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwitchToNewTab implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {


        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Set<String> allHandles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(allHandles);


        driver.switchTo().window(handlesList.get(allHandles.size() - 1));

    }

    public static SwitchToNewTab change() {

        return Instrumented.instanceOf(SwitchToNewTab.class).withProperties();
    }
}
