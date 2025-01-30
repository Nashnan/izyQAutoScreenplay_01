package stepsdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.MessageException;
import models.Credentials;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import questions.CompareName;
import tasks.LoginTask;
import utils.Constants;

import java.util.List;

public class LoginStepsDefinitions {

    @Managed
    WebDriver hisBrowser;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActor("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^The user opens the page in the browser$")
    public void theUserOpensThePageInTheBrowser() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("http://campusvirtual.izyacademy.com:8000/login"));
    }

    @When("^The user enters the credentials$")
    public void theUserEntersTheCredentials(List<Credentials> credentialsList) {
        Credentials credentials;
        credentials = credentialsList.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.enterCredentials(credentials));
    }

    @Then("^The user can see his name$")
    public void theUserCanSeeHisName() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(CompareName.compare(),
                        Matchers.is(Constants.NAME_COMPARATIONS))
                .orComplainWith(MessageException.class, Constants.MESSAGE_EXCEPTION));
    }
}
