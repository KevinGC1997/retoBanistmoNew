package interactions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;



public class WaitTitleWindow implements Interaction {


    private static final Logger log = LoggerFactory.getLogger(WaitTitleWindow.class);
    String title;

    public WaitTitleWindow(String title) {
        this.title = title;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            WebDriver driver = actor.usingAbilityTo(BrowseTheWeb.class).getDriver();
            Dimension windowSize = driver.manage().window().getSize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            System.out.println(driver.getWindowHandles());

            boolean found = wait.until((ExpectedCondition<Boolean>) d -> {
                for(String windowHandle : driver.getWindowHandles()){
                    driver.switchTo().window(windowHandle);

                    //wait.until(ExpectedConditions.titleContains(driver.getTitle()));
                    if (driver.getTitle().equals(title)){
                        return true;
                    }
                }
                return false;
            });

            if (found) {
                log.warn("Window size does not match!");
                driver.manage().window().setSize(windowSize);
            }else {
                log.error("Could not find window with title: {}", title);
            }

        }catch (Exception e) {

            throw new RuntimeException(e);


        }

    }
    public static WaitTitleWindow OnSite(String title) {
        return Tasks.instrumented(WaitTitleWindow.class, title);
    }
}
