package is.serenity.tasks;

import is.serenity.userInterface.HomeUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToContact implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomeUI.LIST_ORGANIZATION, isVisible()),
                Click.on(HomeUI.LIST_ORGANIZATION),
                Click.on(HomeUI.BTN_CONTACT)

        );
    }

    public static Performable on() {
        return Instrumented.instanceOf(GoToContact.class).withProperties();
    }
}
