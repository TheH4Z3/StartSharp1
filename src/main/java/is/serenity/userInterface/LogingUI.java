package is.serenity.userInterface;

import net.serenitybdd.screenplay.targets.Target;

public class LogingUI {

    public static final Target LBL_USER = Target.the("label for user").locatedBy("//input[@id='StartSharp_Membership_LoginPanel0_Username']");
    public static final Target LBL_PASSWORD = Target.the("label for password").locatedBy("//input[@id='StartSharp_Membership_LoginPanel0_Password']");
    public static final Target BTN_SIGN_IN = Target.the("button Sign In").locatedBy("//div/button[@id='StartSharp_Membership_LoginPanel0_LoginButton']");

    //By SonarLint
    private LogingUI() {
        throw new IllegalStateException();
    }
}
