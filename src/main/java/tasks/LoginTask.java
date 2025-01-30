package tasks;

import interactions.WaitElement;
import models.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.LoginPage;

public class LoginTask implements Task {
    Credentials credentials;

    public LoginTask(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credentials.getEmail()).into(LoginPage.TXT_USERNAME));
        actor.attemptsTo(Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PASSWORD));
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGIN));
        actor.attemptsTo(WaitElement.untilBeEnable(LoginPage.BTN_USER));
        actor.attemptsTo(Click.on(LoginPage.BTN_USER));
    }

    public static LoginTask enterCredentials(Credentials credentials){
        return Tasks.instrumented(LoginTask.class, credentials);
    }
}
