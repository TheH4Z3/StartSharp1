package is.serenity.tasks;

import is.serenity.userInterface.ContactsUI;
import is.serenity.interactions.ExplicitWait;
import is.serenity.utils.ReadExcelFile;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.IOException;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CreateContact implements Task {
    public String sheetName = "Hoja1";

    public ReadExcelFile readFile = new ReadExcelFile();
    public ExplicitWait explicitWait = new ExplicitWait(5);


    String filepath = "C:\\Users\\VLADIMIR IGLESIAS\\Desktop\\Test.xlsx";
    String inputValue0 = readFile.getCellValue(filepath, sheetName, 0, 1);
    String inputValue1 = readFile.getCellValue(filepath, sheetName, 1, 1);
    String inputValue2 = readFile.getCellValue(filepath, sheetName, 2, 1);
    String inputValue3 = readFile.getCellValue(filepath, sheetName, 3, 1);
    String inputValue4 = readFile.getCellValue(filepath, sheetName, 4, 1);

    public CreateContact() throws IOException { // default implementation ignored for IOException
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ContactsUI.BTN_NEW_CONTACT, isVisible()),
                Click.on(ContactsUI.BTN_NEW_CONTACT),
                WaitUntil.the(ContactsUI.LBL_TITLE, isVisible()),
                Click.on(ContactsUI.LBL_TITLE),
                Enter.theValue(inputValue0).into(ContactsUI.LBL_TITLE),
                Enter.theValue(inputValue1).into(ContactsUI.LBL_FIRST_NAME),
                Enter.theValue(inputValue2).into(ContactsUI.LBL_LAST_NAME),
                Enter.theValue(inputValue3).into(ContactsUI.LBL_EMAIL),
                Enter.theValue(inputValue4).into(ContactsUI.LBL_IDENTY_NO),
                Click.on(ContactsUI.BTN_SAVE),
                Click.on(ContactsUI.BUTTON_ID),
                Click.on(ContactsUI.BUTTON_ID)

        );
        explicitWait.here(5);
    }

    public static Performable on() {
        return Instrumented.instanceOf(CreateContact.class).withProperties();
    }
}
