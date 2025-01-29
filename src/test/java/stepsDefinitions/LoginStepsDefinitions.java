package stepsDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.aspectj.apache.bcel.classfile.Module;
import org.openqa.selenium.WebDriver;

public class LoginStepsDefinitions {

    @Managed
    WebDriver hisBrowser;

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActor("User");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^The user opens the page in the browser$")
    public void theUserOpensThePageInTheBrowser() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.google.com/"));
    }

    @When("^The user enters the credentials$")
    public void theUserEntersTheCredentials() {

    }

    @Then("^The user can see his name$")
    public void theUserCanSeeHisName() {

    }
}
