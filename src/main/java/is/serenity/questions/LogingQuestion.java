package is.serenity.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static is.serenity.userInterface.ContactsUI.TXT_IDENTITY_NO;

public class LogingQuestion implements Question<String>{

    public static Question<String> IdentityNo() {
        return new LogingQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TXT_IDENTITY_NO.resolveFor(actor).getText();
    }

}
