package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.apache.poi.ss.formula.functions.T;

public class LoginPage {
    public static final Target TXT_USERNAME = Target.the("Enter user")
            .locatedBy("//input[@id='exampleInputEmail1']");

    public static final Target TXT_PASSWORD = Target.the("Enter password")
            .locatedBy("//input[@id='exampleInputPassword1']");

    public static final Target BTN_LOGIN = Target.the("Click on the login button")
            .locatedBy("//button[@id='effect-button']");

    public static final Target BTN_USER = Target.the("Click on the user button")
            .locatedBy("//button[@type='button']");

    public static final Target Compare = Target.the("Get username")
            .locatedBy("//*[contains(@class, 'dropdown-item fw-normal fs-6 ms-1')]");
}
