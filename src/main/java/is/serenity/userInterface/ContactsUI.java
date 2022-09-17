package is.serenity.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class ContactsUI {
    public static final Target BTN_NEW_CONTACT = Target.the("button New Contact").locatedBy("//div[@class='tool-button add-button icon-tool-button']");
    public static final Target LBL_TITLE = Target.the("label Title").locatedBy("//div/form/div/div/div/div/div/input[@id='Serenity_Pro_Organization_ContactDialog4_Title']");
    public static final Target LBL_FIRST_NAME = Target.the("label First Name").locatedBy("//div/form/div/div/div/div/div/input[@id='Serenity_Pro_Organization_ContactDialog4_FirstName']");
    public static final Target LBL_LAST_NAME = Target.the(" label Last Name").locatedBy("//div/form/div/div/div/div/div/input[@id='Serenity_Pro_Organization_ContactDialog4_LastName']");
    public static final Target LBL_EMAIL = Target.the("label Email").locatedBy("//div/form/div/div/div/div/div/input[@id='Serenity_Pro_Organization_ContactDialog4_Email']");
    public static final Target LBL_IDENTY_NO = Target.the("label Identity No").locatedBy("//div/form/div/div/div/div/div/input[@id='Serenity_Pro_Organization_ContactDialog4_IdentityNo']");
    public static final Target LIST_USER = Target.the("list User").locatedBy("//div/form/div/div/div/div/div/div/a[@class='select2-choice select2-default']");
    public static final Target BTN_SAVE = Target.the("button save").locatedBy("//div[@class='tool-button save-and-close-button icon-tool-button']");
    public static final Target TXT_IDENTITY_NO = Target.the("Text IdentityNo").locatedBy("//*[contains(text(),'22768491')]");
    public static final Target BUTTON_ID = Target.the("Buetton ID").locatedBy("(//div/div/span[@class='slick-column-name'])[1]");

    //By SonarLint
    private ContactsUI() {
        throw new IllegalStateException();
    }
}
