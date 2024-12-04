package task;

import interactions.SwitchToNewTab;
import interactions.WaitMoment;
import interactions.WaitTitleWindow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.actions.SwitchToWindowTitle;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userInterface.productServiceUI.*;
import static util.Constants.*;

public class NavigateUser implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_PRODUCT_SERVICES),
                Click.on(BTN_INVESTMENTS),
                Click.on(BTN_VIRTUAL_INVESTMENTS),
                SwitchToNewTab.change(),
                WaitUntil.the(LBL_SCROLL_DOCUMENT, isVisible()).forNoMoreThan(19).seconds(),
                Scroll.to(LBL_SCROLL_DOCUMENT),
                Click.on(LBL_SCROLL_DOCUMENT),
                Click.on(BTN_REGULATIONS),
                WaitMoment.pageInSeconds(10),
                SwitchToNewTab.change()
        );



    }
    public static NavigateUser onSite() {
        return Tasks.instrumented(NavigateUser.class);
    }
}
