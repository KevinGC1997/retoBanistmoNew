package stepDefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import questions.UrlPdf;
import task.NavigateUser;
import util.Constants;
import util.Driver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProductServicesStepDefinitions {


    @Given("user open application")
    public void userOpenApplication() {
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(Driver.chrome().onUrl(Constants.URL)));
    }
    @When("navigate in the app to see the regulation")
    public void navigateInTheAppToSeeTheRegulation() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                NavigateUser.onSite()
        );
    }
    @Then("validate that the url is correct {string}")
    public void validateThatTheUrlIsCorrect(String string) {
        OnStage.theActorInTheSpotlight().should(

                seeThat(
                        "the url is", UrlPdf.was(), equalTo(string)
                )
        );
    }

}
