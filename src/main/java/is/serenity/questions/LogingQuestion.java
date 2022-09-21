package is.serenity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static is.serenity.userInterface.HomeUI.TXT_VALIDATION_HOME;

public class LogingQuestion implements Question<String>{

    public static Question<String> TextHome() {
        return new LogingQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TXT_VALIDATION_HOME.resolveFor(actor).getText();
    }

}
