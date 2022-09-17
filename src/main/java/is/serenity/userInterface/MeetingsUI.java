package is.serenity.userInterface;

import net.serenitybdd.screenplay.targets.Target;

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
