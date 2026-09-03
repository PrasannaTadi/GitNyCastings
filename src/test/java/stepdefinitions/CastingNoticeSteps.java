package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CastingNoticeDetailsPage;
import pageObjects.CastingNoticePage;
import pageObjects.LoginPage;
import utilities.DriverFactory;

public class CastingNoticeSteps {
    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait;
    CastingNoticePage castingNoticePage;
    LoginPage loginPage;
    CastingNoticeDetailsPage castingNoticeDetailsPage;

    // You must initialize the page object before using it
    public CastingNoticeSteps(){
        this.castingNoticePage= new CastingNoticePage(driver);
        this.loginPage = new LoginPage(driver);
        this.castingNoticeDetailsPage = new CastingNoticeDetailsPage(driver);
    }

    @Given("User is On the CastingNotices Page")
    public void userIsOnTheCastingNoticesPage() {

        castingNoticePage.ClickOnCastingNotices();

    }

    @Then("Click on the NoticeTitle")
    public void clickOnTheNoticeTitle() {

        castingNoticePage.ClickOnNoticeTitle();
    }

    @Then("Verify user navigating to the child window")
    public void verifyUserNavigatingToTheChildWindow() {

        Assert.assertTrue(
                "Child window was not opened",
                castingNoticePage.verifyChildWindowOpened()
                );

        castingNoticePage.switchToChildWindow();
    }

    @And("Click on the Role title")
    public void clickOnTheRoleTitle() {
        castingNoticeDetailsPage.ClickOnRoleTitle();

    }

    @And("Select the Media")
    public void selectTheMedia() {
    }

    @Then("Click on the Submit button")
    public void clickOnTheSubmitButton() {
    }


    @And("Verify applied tag is showing on the main casting notices page")
    public void verifyAppliedTagIsShowingOnTheMainCastingNoticesPage() {
        // Switch back to main window
        castingNoticePage.switchToMainWindow();
    }
}
