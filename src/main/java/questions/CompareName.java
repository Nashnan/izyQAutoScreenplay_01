package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.LoginPage;

public class CompareName implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Text.of(LoginPage.Compare).viewedBy(actor).asString();
    }

    public static CompareName compare(){
        return new CompareName();
    }
}
