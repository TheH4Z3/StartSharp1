package is.serenity.tasks;

import is.serenity.userInterface.HomeUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToMeeting implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomeUI.LIST_MEETING, isVisible()),
                Click.on(HomeUI.LIST_MEETING),
                Click.on(HomeUI.BTN_MEETINGS)
        );
    }

    public static Performable on() {
        return Instrumented.instanceOf(GoToMeeting.class).withProperties();
    }


}
