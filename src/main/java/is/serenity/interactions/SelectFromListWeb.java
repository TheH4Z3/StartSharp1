package is.serenity.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectFromListWeb implements Interaction {

    private final Target element;
    private final int index;

    public SelectFromListWeb(Target element, int index) {
        this.element = element;
        this.index = index;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement listLocation = element.resolveFor(actor);
        List<WebElement> options = listLocation.findElements(By.tagName("li"));
        options.get(index).click();
    }

    public static SelectFromListWeb index(Target element, int index) {
        return Instrumented.instanceOf(SelectFromListWeb.class).withProperties(element, index);
    }
}
