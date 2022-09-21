package is.serenity.tasks;

import is.serenity.interactions.ExplicitWait;
import is.serenity.interactions.SelectFromList;
import is.serenity.interactions.SelectFromListWeb;
import is.serenity.userInterface.MeetingsUI;
import is.serenity.utils.ReadExcelFile;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateNewMeeting implements Task {
    public ExplicitWait explicitWait = new ExplicitWait(5);


    public String sheetName = "Hoja1";
    public ReadExcelFile readFile = new ReadExcelFile();
    String filepath = "Test.xlsx";
    String inputValue1 = readFile.getCellValue(filepath, sheetName, 1, 1);
    String inputValue4 = readFile.getCellValue(filepath, sheetName, 4, 1);

    public CreateNewMeeting() throws IOException { // default implementation ignored for IOException
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MeetingsUI.BTN_NEW_MEETING, isVisible()),
                Click.on(MeetingsUI.BTN_NEW_MEETING),
                WaitUntil.the(MeetingsUI.LBL_MEETING_NAME, isVisible()),
                Enter.theValue("INDUCCION NUEVO INGRESO").into(MeetingsUI.LBL_MEETING_NAME),
                Enter.theValue(inputValue4).into(MeetingsUI.LBL_MEETING_NUMBER),
                Click.on(MeetingsUI.LIST_MEETING_TYPE)
        );

        int a = (int) (Math.random() * 6);

        switch (a) {
            default:
            case 0:
                actor.attemptsTo(Click.on(MeetingsUI.LIST_MEETING_ELEMENT_1));
                break;

            case 1:
                actor.attemptsTo(Click.on(MeetingsUI.LIST_MEETING_ELEMENT_2));
                break;

            case 2:
                actor.attemptsTo(Click.on(MeetingsUI.LIST_MEETING_ELEMENT_3));
                break;

            case 3:
                actor.attemptsTo(Click.on(MeetingsUI.LIST_MEETING_ELEMENT_4));
                break;

            case 4:
                actor.attemptsTo(Click.on(MeetingsUI.LIST_MEETING_ELEMENT_5));
                break;

            case 5:
                actor.attemptsTo(Click.on(MeetingsUI.LIST_MEETING_ELEMENT_6));
                break;
        }


        actor.attemptsTo(

                Click.on(MeetingsUI.BTN_START_DATE),
                WaitUntil.the(MeetingsUI.BTN_TODAY1, isVisible()),
                Click.on(MeetingsUI.BTN_TODAY1),
                Click.on(MeetingsUI.BTN_DONE),
                Click.on(MeetingsUI.BTN_END_DATE),
                WaitUntil.the(MeetingsUI.BTN_TODAY2, isVisible()),
                Click.on(MeetingsUI.BTN_TODAY2),
                Click.on(MeetingsUI.BTN_DONE),
                Click.on(MeetingsUI.BTN_TIME1),
                Click.on(MeetingsUI.BTN_TIME2),

                WaitUntil.the(MeetingsUI.LIST_TIME1, isVisible()),
                SelectFromList.index(MeetingsUI.LIST_TIME1, 1),
                WaitUntil.the(MeetingsUI.LIST_TIME2, isVisible()),
                SelectFromList.index(MeetingsUI.LIST_TIME2, 6),
                WaitUntil.the(MeetingsUI.LIST_LOCATION_ITEMS, isVisible()),
                Click.on(MeetingsUI.LIST_LOCATION_ITEMS),
                WaitUntil.the(MeetingsUI.LIST_LOCATION, isVisible()),
                SelectFromListWeb.index(MeetingsUI.LIST_LOCATION, 4),
                WaitUntil.the(MeetingsUI.LIST_UNIT, isVisible()),
                Click.on(MeetingsUI.LIST_UNIT),
                SelectFromListWeb.index(MeetingsUI.LIST_UNIT_ITEMS, 3),
                Click.on(MeetingsUI.LIST_ORGANIZED_BY),
                WaitUntil.the(MeetingsUI.LIST_ORGANIZED_BY_ITEMS, isVisible()),
                SelectFromListWeb.index(MeetingsUI.LIST_ORGANIZED_BY_ITEMS, 2),
                Click.on(MeetingsUI.LIST_ATTENDEE),
                Click.on(MeetingsUI.LBL_SEARCH_ATTENDEE),
                Enter.theValue(inputValue1).into(MeetingsUI.LBL_SEARCH_ATTENDEE)

        );

        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);


        actor.attemptsTo(
                Click.on(MeetingsUI.BTN_SAVE)
        );

        ExplicitWait.here(5);

    }

    public static Performable on() {
        return Instrumented.instanceOf(CreateNewMeeting.class).withProperties();
    }
}
