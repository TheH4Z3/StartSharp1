package is.serenity.stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import is.serenity.questions.IdentityNoQuestion;
import is.serenity.tasks.CreateNewMeeting;
import is.serenity.tasks.GoToMeeting;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NewMeetingStepDefinitions {

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^Tester create new meeting with new contact$")
    public void testerCreateNewMeetingWithNewContact() {
    OnStage.theActorInTheSpotlight().attemptsTo(

            GoToMeeting.on(),
            CreateNewMeeting.on()

    );

    }

    @Then("^Tester will be able see the meeting was succesfully scheduled (.*)$")
    public void testerWillBeAbleSeeTheMeetingWasSuccesfullyScheduled(String text2) {
        OnStage.theActorInTheSpotlight().should(seeThat(IdentityNoQuestion.IdentityNo(), equalTo(text2)));
    }


}
