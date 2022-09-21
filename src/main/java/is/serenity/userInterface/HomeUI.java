package is.serenity.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class HomeUI {
    public static final Target TXT_VALIDATION_HOME = Target.the("Text for validate login").locatedBy("//div/h5[contains(text(),'StartSharp')]");
    public static final Target LINK_DASHBOARD = Target.the("link dashboard").locatedBy("//div/div/div/ul/li/a[@class='s-sidebar-link']");
    public static final Target LIST_ORGANIZATION = Target.the("list Organization").locatedBy("//li/ul/li/a[@data-bs-toggle='collapse' and @href='#nav_menu1_3_1']");
    public static final Target BTN_CONTACT = Target.the("button contact").locatedBy("//li/ul/li/a[@href='/demo/Organization/Contact']");
    public static final Target LIST_MEETING = Target.the("list Meeting").locatedBy("//li/ul/li/a[@data-bs-toggle='collapse' and @href='#nav_menu1_3_2']");
    public static final Target BTN_MEETINGS = Target.the("button Meetings").locatedBy("//li/ul/li/a[@href='/demo/Meeting/Meeting']");

    //By SonarLint
    private HomeUI() {
        throw new IllegalStateException();
    }
}
