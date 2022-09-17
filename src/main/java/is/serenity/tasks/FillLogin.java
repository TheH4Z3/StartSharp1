package is.serenity.tasks;

import is.serenity.userInterface.LogingUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillLogin implements Task {
    private String user;
    private String password;

    public FillLogin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LogingUI.LBL_USER, isVisible()),
                Enter.theValue(user).into(LogingUI.LBL_USER),
                Enter.theValue(password).into(LogingUI.LBL_PASSWORD),
                Click.on(LogingUI.BTN_SIGN_IN)
        );

    }

    public static Performable on(String user, String password) {
        return Instrumented.instanceOf(FillLogin.class).withProperties(user, password);
    }

}