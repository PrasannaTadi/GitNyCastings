package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MyProjectsPage;
import utilities.ContextKeys;
import utilities.DriverFactory;
import utilities.ScenarioContext;

public class MyProjectsSteps {
    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait;
    MyProjectsPage myProjectsPage;

    // You must initialize the page object before using it
    public MyProjectsSteps(){
        this.myProjectsPage = new MyProjectsPage(driver);
    }

    @And("Verify the WelocmeText for newDirector")
    public void verifyTheWelocmeTextForNewDirector() {
        Assert.assertTrue(myProjectsPage.verifyWelcomeText());
    }

    @Then("Verify Search Talent is disabled")
    public void verifySearchTalentIsDisabled() {
        Assert.assertTrue(
                myProjectsPage.isSearchTalentDisabled());
        
    }

    @Then("Verify clicking Search Talent does not navigate to Dashboard")
    public void verifyClickingSearchTalentDoesNotNavigateToDashboard() {
        Assert.assertTrue(
                myProjectsPage.isSearchTalentNotNavigating());
    }


    @Then("Click on Create New casting call")
    public void clickOnCreateNewCastingCall() {
        myProjectsPage.clickOnCreateCastingCall();

    }

    @Then("Enter the Project title and Store the Title")
    public void enterTheProjectTitleAndStoreTheTitle() {
       // myProjectsPage.AddProjectTitle();
        String ProjectTitleName = myProjectsPage.AddProjectTitle();
        ScenarioContext.set(ContextKeys.PROJECTTITLENAME,ProjectTitleName);

    }
    @Then("Add the Role Name and Store the value")
    public void addTheRoleNameAndStoreTheValue() {
        String RoleTitleName = myProjectsPage.EnterRolename();
        ScenarioContext.set(ContextKeys.ROLETITLENAME,RoleTitleName);
    }
    @Then("add Description")
    public void addDescription() {
        myProjectsPage.AddProjectDecription("Automation Description");
    }
    @And("Select location {string} from dropdown and store the value")
    public void selectLocationFromDropdownAndStoreTheValue(String locationValue) {
        String selectedLocation = myProjectsPage.AddLocation(locationValue);

        ScenarioContext.set(ContextKeys.LOCATION, selectedLocation);

        System.out.println("Selected Location: " + selectedLocation);

    }
    @Then("Select Category {string} from dropdown and store the value")
    public void selectCategoryFromDropdownAndStoreTheValue(String CategoryValue) {
        String selectedCategory = myProjectsPage.AddCategory(CategoryValue);

        ScenarioContext.set(ContextKeys.CATEGORY, selectedCategory);

        System.out.println("Selected CATEGORY: " + selectedCategory);
    }
    @Then("Select union {string} from Union dropdown and store the value")
    public void selectUnionFromUnionDropdownAndStoreTheValue(String unionName) {
        String selectedUnion = myProjectsPage.selectCastingCallUnion(unionName);

        ScenarioContext.set(ContextKeys.UNION,selectedUnion );
        System.out.println("Selected UNION: " + selectedUnion);
    }
    @And("Add Casting info text data")
    public void addCastingInfoTextData() {
        myProjectsPage.AddCastInfo("Automation Casting info text");
    }
    @Then("Select the Pay Type from dropdown")
    public void selectThePayTypeFromDropdown() {
        myProjectsPage.SelectPaytype();
    }
    @Then("add payScale")
    public void addPayScale() {
        myProjectsPage.AddPayScale("Automation PayScale Text ");
    }
    @Then("Select the date")
    public void selectTheDate() {
    }
    @And("Upload the Picture")
    public void uploadThePicture() {
    }
    @And("Upload the Script")
    public void uploadTheScript() {
    }
    @And("click on save as Draft")
    public void clickOnSaveAsDraft() {
        myProjectsPage.SaveAsDraft();
    }
    @Then("Verify the navigated to projects page")
    public void verifyTheNavigatedToProjectsPage() {
    }
    @And("Verify the created project title is displaying with Pending tag")
    public void verifyTheCreatedProjectTitleIsDisplayingWithPendingTag() {
    }

    @And("click on save and continue")
    public void clickOnSaveAndContinue() {
        myProjectsPage.SaveAndCountinue();

    }

    @Then("Verify user is navigated to role Creator page")
    public void verifyUserIsNavigatedToRoleCreatorPage() {
        System.out.println(myProjectsPage.roleCreatorPageIsDisplayed());
        Assert.assertTrue(myProjectsPage.roleCreatorPageIsDisplayed());
    }

    @And("Preview Notice Button is disabled")
    public void previewNoticeButtonIsDisabled() {
        System.out.println(myProjectsPage.previewNoticeDisabled());
        Assert.assertFalse(myProjectsPage.previewNoticeDisabled());

    }


    @And("Age min and max")
    public void ageMinAndMax() {
        myProjectsPage.AddAge();
    }

    @And("Select the Gender from the dropdown")
    public void selectTheGenderFromTheDropdown() {
        myProjectsPage.Selecgender();
    }

    @And("Select the Ethnicity from the dropdown")
    public void selectTheEthnicityFromTheDropdown() {
        myProjectsPage.SelectEthnicity();
    }

    @And("Select the Role type from the dropdwon")
    public void selectTheRoleTypeFromTheDropdwon() {
        myProjectsPage.SelectRoleType();
    }

    @Then("click on save the Role")
    public void clickOnSaveTheRole() {
        myProjectsPage.clickonSaveRole();
    }

    @And("Verify added role displaying on page with title")
    public void verifyAddedRoleDisplayingOnPageWithTitle() {
        String roleTitle = (String)ScenarioContext.get(ContextKeys.ROLETITLENAME);

        boolean displayed = myProjectsPage.isRoleDisplayed(roleTitle);

        Assert.assertTrue(displayed);
        System.out.println(myProjectsPage.isRoleDisplayed(roleTitle));

    }

    @And("click on Preview notice")
    public void clickOnPreviewNotice() {
        myProjectsPage.clickonPreviewNotice();
    }

    @Then("Verify preview Notice page is opened")
    public void verifyPreviewNoticePageIsOpened() {
    }

    @And("Verify Notice details and Role Details")
    public void verifyNoticeDetailsAndRoleDetails() {
    }

    @Then("click on SUBMIT NOTICE button")
    public void clickOnSUBMITNOTICEButton() {
        myProjectsPage.clickonSaveSubmitNotice();
        
    }

    @And("Verify User navigated to dashboard page")
    public void verifyUserNavigatedToDashboardPage() {
    }


    @Then("select the expirydate")
    public void selectTheExpirydate() {
myProjectsPage.enterdate();
    }

    @Then("Verify preview Notice is enabled")
    public void verifyPreviewNoticeIsEnabled() {
System.out.println(myProjectsPage.isPreviewNoticeEnabled());
Assert.assertTrue(myProjectsPage.isPreviewNoticeEnabled());
    }


    @And("Verify created notice title is displaying on the top of the list and Pending Label is showing")
    public void verifyCreatedNoticeTitleIsDisplayingOnTheTopOfTheListAndPendingLabelIsShowing() {
        String projectTitle = (String)ScenarioContext.get(ContextKeys.PROJECTTITLENAME);

        Assert.assertTrue(myProjectsPage.verifyProjectIsAtTop(projectTitle));
        Assert.assertTrue(myProjectsPage.verifyProjectIsPending(projectTitle));
        System.out.println(myProjectsPage.verifyProjectIsAtTop(projectTitle));
        System.out.println(myProjectsPage.verifyProjectIsPending(projectTitle));
    }

    @And("Verify the added Location is showing")
    public void verifyTheAddedLocationIsShowing() {


    }



}
