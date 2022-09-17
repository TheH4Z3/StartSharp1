# StartSharp


Executes automation on the site
 [StartSharp](https://serenity.is/demo/)

 Using:
[SerenityBDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html),[Java](https://www.java.com/es/),[Gradle](https://gradle.org/), [Cucumber](https://cucumber.io/) and Screenplay.


## Code Structure

the code was developed using screenplay pattern. All description below:
<table>
<tr>
  <th>Tasks</th>
  <td>
    <h6>Contains all the task to execute on the automation</h6>
  </td>
</tr>
  <tr>
  <th>Interactions</th>
  <td>
    <h6>Contains all the interactions to execute on the automation</h6>
  </td>
</tr>
  <tr>
  <th>Models</th>
  <td>
    <h6>Contains all the models for with getters and setters for the execution data</h6>
  </td>
</tr>
  <tr>
  <th>UserInterface</th>
  <td>
    <h6>contains all classes with the selectors for each site</h6>
  </td>
</tr>
  <tr>
  <th>Driver</th>
  <td>
    <h6>contains all the drivers for each browser</h6>
  </td>
</tr>
  <tr>
  <th>Runners</th>
  <td>
    <h6>Contains all the runers to run the automation</h6>
  </td>
</tr>
  <tr>
  <th>Steps Definitions</th>
  <td>
    <h6>Contains all the step definitions for the execution </h6>
  </td>
</tr>
  <tr>
  <th>Features</th>
  <td>
    <h6>Contains all the scenarios under the Gherkin language</h6>
  </td>
</tr>
<tr>
  <th>Questions</th>
  <td>
    <h6>Contains all the validations to ensure the tests</h6>
  </td>
</tr>
<tr>
  <th>Utils</th>
  <td>
    <h6>Contains all the classes with reusable methods</h6>
  </td>
</tr>
</table>


#### Driver

#### SeleniumWebDriver

In this section, we declare the browser settings and properties. And how we would like start.

```java
public class SeleniumWebDriver {
    public static WebDriver driver;

    public static SeleniumWebDriver ChromeWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--star-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        return new SeleniumWebDriver();
    }

    public static WebDriver on(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

}
```

#### Interactions

#### ExplicitWait
this is an interaction that allows to stop the execution of the code


```java

public class ExplicitWait implements Interaction {
    long secs;

    public ExplicitWait(int secs) {
        this.secs = secs;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException ignored) {

        }

    }

    public static ExplicitWait here(int secs) {
        return Instrumented.instanceOf(ExplicitWait.class).withProperties(secs);
    }
}
```

#### SelectFromList
this is an interaction that allows select the position of an element 


```java
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
```





#### SelectFromListWeb
this is an interaction that allows select the position of an element, but this must be a web element


```java
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
```

### Models

#### Model
This class use objects of these classes as vessels to send or receive data. As an example `getUser` and `getPassword`


```java
public class Model {
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
```

#### Questions

#### IdentityNoQuestion
Here we can validate an element to make sure it is able.

```java
public class IdentityNoQuestion implements Question<String>{

    public static Question<String> IdentityNo() {
        return new IdentityNoQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TXT_IDENTITY_NO.resolveFor(actor).getText();
    }
}
```

### LogingQuestion
Here we can validate an element to make sure it is able.

```java
public class LogingQuestion implements Question<String>{

    public static Question<String> IdentityNo() {
        return new LogingQuestion();
    }

    @Override
    public String answeredBy(Actor actor) {
        return TXT_IDENTITY_NO.resolveFor(actor).getText();
    }
    
}
```

### Tasks

### CreateContact
This task creates a new contact in the web

```java
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
```


### CreateNewMeeting

This task creates a new meeting only for new contacts


```java
public class CreateNewMeeting implements Task {
    public ExplicitWait explicitWait = new ExplicitWait(5);


    public String sheetName = "Hoja1";
    public ReadExcelFile readFile = new ReadExcelFile();
    String filepath = "C:\\Users\\VLADIMIR IGLESIAS\\Desktop\\Test.xlsx";
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
```

#### FillLogin

This task just fill the Login labels

```java
public class FillLogin implements Task {
    private String user;
    private String password;

    public FillLogin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LogingUI.LBL_USER, isVisible()),
                Enter.theValue(user).into(LogingUI.LBL_USER),
                Enter.theValue(password).into(LogingUI.LBL_PASSWORD),
                Click.on(LogingUI.BTN_SIGN_IN)
        );

    }

    public static Performable on(String user, String password) {
        return Instrumented.instanceOf(FillLogin.class).withProperties(user, password);
    }

}
```

#### GoToContact
This task implements an action for go to UI `Contact`

```java
public class GoToContact implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomeUI.LIST_ORGANIZATION, isVisible()),
                Click.on(HomeUI.LIST_ORGANIZATION),
                Click.on(HomeUI.BTN_CONTACT)

        );
    }

    public static Performable on() {
        return Instrumented.instanceOf(GoToContact.class).withProperties();
    }
}

```

#### GoToMeeting
This task implements an action for go to UI `Meetings`


```java
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
```

#### UserInterface
Here its where we store all elemts and `Xpath`


### ContactsUI

```java
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
```

#### HomeUI

```java
public class HomeUI {
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
```

#### LogingUI

```java
public class LogingUI {

    public static final Target LBL_USER = Target.the("label for user").locatedBy("//input[@id='StartSharp_Membership_LoginPanel0_Username']");
    public static final Target LBL_PASSWORD = Target.the("label for password").locatedBy("//input[@id='StartSharp_Membership_LoginPanel0_Password']");
    public static final Target BTN_SIGN_IN = Target.the("button Sign In").locatedBy("//div/button[@id='StartSharp_Membership_LoginPanel0_LoginButton']");

    //By SonarLint
    private LogingUI() {
        throw new IllegalStateException();
    }
}
```



### MeetingsUI

```java
public class MeetingsUI {
    public static final Target BTN_NEW_MEETING = Target.the("button New Meeting").locatedBy("(//div/span[@class='button-inner'])[1]");
    public static final Target LBL_MEETING_NAME = Target.the("label Meeting Name").locatedBy("//div/input[@id='Serenity_Pro_Meeting_MeetingDialog10_MeetingName']");
    public static final Target LIST_MEETING_TYPE = Target.the("list Meeting Type").locatedBy("//div/a[@class='select2-choice']");
    public static final Target LIST_MEETING_ELEMENT_1 = Target.the("list Meeting Element 1").locatedBy("(//div/ul/li/div[@class='select2-result-label'])[1]");
    public static final Target LIST_MEETING_ELEMENT_2 = Target.the("list Meeting Element 2").locatedBy("(//div/ul/li/div[@class='select2-result-label'])[2]");
    public static final Target LIST_MEETING_ELEMENT_3 = Target.the("list Meeting Element 3").locatedBy("(//div/ul/li/div[@class='select2-result-label'])[3]");
    public static final Target LIST_MEETING_ELEMENT_4 = Target.the("list Meeting Element 4").locatedBy("(//div/ul/li/div[@class='select2-result-label'])[4]");
    public static final Target LIST_MEETING_ELEMENT_5 = Target.the("list Meeting Element 5").locatedBy("(//div/ul/li/div[@class='select2-result-label'])[5]");
    public static final Target LIST_MEETING_ELEMENT_6 = Target.the("list Meeting Element 1").locatedBy("(//div/ul/li/div[@class='select2-result-label'])[6]");
    public static final Target LBL_MEETING_NUMBER = Target.the("label Meeting Number").locatedBy("//div/input[@id='Serenity_Pro_Meeting_MeetingDialog10_MeetingNumber']");
    public static final Target BTN_START_DATE = Target.the("button Start Date").locatedBy("(//div/button[@class='ui-datepicker-trigger'])[1]");
    public static final Target BTN_END_DATE = Target.the("button End Date").locatedBy("(//div/button[@class='ui-datepicker-trigger'])[2]");
    public static final Target BTN_TODAY1 = Target.the("button Today #1").locatedBy("//div/button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']");
    public static final Target BTN_TODAY2 = Target.the("button Today #2").locatedBy("//div/button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all']");
    public static final Target BTN_DONE = Target.the("button Done").locatedBy("//div/button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']");
    public static final Target BTN_TIME1 = Target.the("button Current time #1").locatedBy("(//div/i[@class='inplace-button inplace-now'])[1]");
    public static final Target BTN_TIME2 = Target.the("button Current time #2").locatedBy("(//div/i[@class='inplace-button inplace-now'])[2]");
    public static final Target LIST_TIME1 = Target.the("list Time #1").locatedBy("//div[@class='field StartDate col-sm-6']/select");
    public static final Target LIST_TIME2 = Target.the("list Time #2").locatedBy("//div[@class='field EndDate col-sm-6']//select");
    public static final Target LIST_LOCATION = Target.the("list Location").locatedBy("//div/ul[@id='select2-results-7']");
    public static final Target LIST_LOCATION_ITEMS = Target.the("list Location Items").locatedBy("//div/div[@id='s2id_Serenity_Pro_Meeting_MeetingDialog10_LocationId']/a");
    public static final Target LIST_UNIT = Target.the("list Unit").locatedBy("//div/div[@id='s2id_Serenity_Pro_Meeting_MeetingDialog10_UnitId']/a");
    public static final Target LIST_UNIT_ITEMS = Target.the("list Unit Items").locatedBy("//ul[@id='select2-results-8']");
    public static final Target LIST_ORGANIZED_BY = Target.the("list Organized By").locatedBy("//div/div[@id='s2id_Serenity_Pro_Meeting_MeetingDialog10_OrganizerContactId']/a");
    public static final Target LIST_ORGANIZED_BY_ITEMS = Target.the("list Organized By Items").locatedBy("//div[@id='select2-drop']/ul");
    public static final Target LIST_ATTENDEE = Target.the("list Attendee").locatedBy("//div/div[@id='s2id_autogen11']/a");
    public static final Target LBL_SEARCH_ATTENDEE = Target.the("lbl Attendee").locatedBy("//div/div/input[@id='s2id_autogen12_search']");
    public static final Target BTN_SAVE = Target.the("button Save").locatedBy("(//div/span[@class='button-inner'])[4]");

    //By SonarLint
    private MeetingsUI() {
        throw new IllegalStateException();
    }
}
```



#### Utils

#### Data
This class contains the url for `ChromeDriver`

```java
package is.serenity.utils;

public class Data {
    public static final String url = "https://serenity.is/demo/";

}
```

#### ReadExcelFile
Here is an generic method for read `.XLSX ` files

```java
public class ReadExcelFile {
    public void readExcel(String filepath, String sheetName) throws IOException {

        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        int rowCount = newSheet.getLastRowNum() - newSheet.getFirstRowNum();

        for (int i = 0; i <= rowCount; i++) {
            XSSFRow row = newSheet.getRow(i);

            for (int j = 0; j < row.getLastCellNum(); j++) {
                System.out.println(row.getCell(j).getNumericCellValue() + "||");
            }
        }
    }

    public String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {

        File file = new File(filepath);

        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);

        XSSFSheet newSheet = newWorkbook.getSheet(sheetName);

        XSSFRow row = newSheet.getRow(rowNumber);

        XSSFCell cell = row.getCell(cellNumber);

        return cell.getStringCellValue();
    }

}

```

### Runners
This method manages all snippets for each step, getting data from `.feature file`

#### AddContactRunner

```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/AddContact.feature",
        glue = "is.serenity.stepDefinitions",
        snippets = SnippetType.CAMELCASE
)

public class AddContactRunner {
}
```

### NewMeetingRunner

```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/NewMeeting.feature",
        glue = "is.serenity.stepDefinitions",
        snippets = SnippetType.CAMELCASE
)

public class NewMeetingRunner {

}
```



### stepDefinitions
Here we can paste the `snippets` to instantiate the steps

### AddContactStepDefinition

```java
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
        OnStage.theActorInTheSpotlight().should(seeThat(IdentityNoQuestion.IdentityNo(), equalTo(text)));

    }

}
```


### NewMeetingStepDefinitions

```java
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
```



### Features
This is the .feature file. Here we create different scenarios for each test case 

#### AddContact.feature

```
Feature: Add contacts from Excel to contacts list


  Scenario Outline: Add Contact
    Given Tester opens the StartSharp login
    When Tester wants to loging, he types his credentials
      | user  | password |
      | admin | serenity |

    Then Tester can add a new contact to contacts list <text>

    Examples:
      | text     |
      | 22768491 |

```


#### NewMeeting.feature

```
Feature: Create new meeting with new contact

  Scenario Outline: Tester wants create new meeting for new contact
    Given Tester opens the StartSharp login
    When Tester wants to loging, he types his credentials
      | user  | password |
      | admin | serenity |

    When Tester create new meeting with new contact

    Then Tester will be able see the meeting was succesfully scheduled <text2>
    Examples:
      | text2    |
      | 22768491 |

```


## Execution

On the ItelliJ IDE we must type the follow command.

```yml
    gradle clean test aggregate
```
these command executes the whole project, and the scenarios on this project

```cmd
    3 actionable tasks: 3 executed
```

At the end we must go and open the file `index.html` that is located on on the following route

```yml
  <ProjectoName>\target\site\serenity\index.html
```

This Readme.md was made by Vladimir Iglesias Arrieta