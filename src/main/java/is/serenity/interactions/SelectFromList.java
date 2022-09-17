package is.serenity.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFromList implements Interaction {
    private final Target element;
    private final int index;

    public SelectFromList(Target element, int index) {
        this.element = element;
        this.index = index;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement hour = element.resolveFor(actor);
        hour.click();
        Select listSelect = new Select(hour);
        listSelect.selectByIndex(index);
    }

    public static SelectFromList index(Target element, int index) {
        return Instrumented.instanceOf(SelectFromList.class).withProperties(element, index);
    }
}
