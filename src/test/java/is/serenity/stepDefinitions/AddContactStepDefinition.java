package is.serenity.stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import is.serenity.driver.SeleniumWebDriver;
import is.serenity.models.Model;
import is.serenity.questions.IdentityNoQuestion;
import is.serenity.questions.LogingQuestion;
import is.serenity.tasks.CreateContact;
import is.serenity.tasks.FillLogin;
import is.serenity.tasks.GoToContact;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import java.util.List;
import static is.serenity.utils.Data.url;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class AddContactStepDefinition {


    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^Tester opens the StartSharp login$")
    public void testerOpensTheStartSharpLoginHttpsSerenityIsDemo() {
        SeleniumWebDriver.ChromeWebDriver();
        theActorCalled("Tester").can(BrowseTheWeb.with(SeleniumWebDriver.on(url)));
    }

    @When("^Tester wants to loging, he types his credentials$")
    public void testerWantsToLogingHeTypesHisCredentials(List<Model> inyection) {
        theActorInTheSpotlight().attemptsTo(FillLogin.on(inyection.get(0).getUser(), inyection.get(0).getPassword()));
    }

    @Then("^Tester can add a new contact to contacts list (.*)$")

    public void testerCanAddANewContactToContactsList(String text) {
        theActorInTheSpotlight().attemptsTo(
                GoToContact.on(),
                CreateContact.on()
        );
        OnStage.theActorInTheSpotlight().should(seeThat(LogingQuestion.TextHome(), equalTo(text)));

    }

}
