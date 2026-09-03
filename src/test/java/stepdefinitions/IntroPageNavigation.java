package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.IntroPageNavigationPage;
import pageObjects.LoginPage;
import utilities.DriverFactory;
import utilities.ScenarioContext;
import java.time.Duration;

public class IntroPageNavigation {
    WebDriver driver = DriverFactory.getDriver();
    IntroPageNavigationPage introPageNavigationPage;
    LoginPage loginPage;
    private WebDriverWait wait;

    // You must initialize the page object before using it
    public IntroPageNavigation() {
        this.introPageNavigationPage = new IntroPageNavigationPage(driver);
        this.loginPage = new LoginPage(driver);
    }

        @Then("click on directSubmit logo")
        public void clickOnDirectSubmitLogo() {
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
           introPageNavigationPage.verifyClickingOnIntroPage();
        }
    public void validateIntroPage() {
        //Assert.assertTrue(driver.getTitle().contains("DirectSubmit"));
    }

    @Then("Verify Intro page URL")
    public void verifyIntroPageURL() {
        Assert.assertEquals("https://casting-dev.directsubmit.com/talentintro",
                driver.getCurrentUrl());
       // Assert.assertTrue(driver.getCurrentUrl().contains("talentintro"));
    }

    @And("Verify DirectSubmit logo is displayed")
    public void verifyDirectSubmitLogoIsDisplayed() {
        Assert.assertTrue(introPageNavigationPage.isLogoDisplayed());
    }

    @And("Verify I AM TALENT toggle text is displayed")
    public void verifyIAMTALENTToggleTextIsDisplayed() {
        Assert.assertTrue(introPageNavigationPage.isIamTalentDisplayed());
    }

    @And("Verify I'M A CASTING DIRECTOR toggle text is displayed")
    public void verifyIMACASTINGDIRECTORToggleTextIsDisplayed() {
        Assert.assertTrue(introPageNavigationPage.isCastingDirectorDisplayed());
    }

    @And("Verify the toggle button is displayed")
    public void verifyTheToggleButtonIsDisplayed() {
        Assert.assertTrue(introPageNavigationPage.toggleButtonDisplayed());
    }

    @And("Verify Start Free Trial button is displayed")
    public void verifyStartFreeTrialButtonIsDisplayed() {
        Assert.assertTrue(introPageNavigationPage.isStartTrialDisplayed());
    }

    @And("Verify See Today's Casting Calls button is displayed")
    public void verifySeeTodaySCastingCallsButtonIsDisplayed() {
        Assert.assertTrue(introPageNavigationPage.isTodayCastingCallButtonDisplayed());
    }

    @And("Verify Direct Submit booked heading is displayed")
    public void verifyDirectSubmitBookedHeadingIsDisplayed() {
        Assert.assertTrue(introPageNavigationPage.isHeadingDisplayed());
    }

    @And("Verify Description text is displayed")
    public void verifyDescriptionTextIsDisplayed() {
        String expected =
                "Find casting calls for actors, models, dancers, singers, and voice-over talent. Submit directly to film, TV, theater, commercial, and digital media opportunities.";

        Assert.assertEquals(expected, introPageNavigationPage.getHeroDescription());
    }

    @And("Verify Statistics section is displayed")
    public void verifyStatisticsSectionIsDisplayed() {
        Assert.assertTrue(introPageNavigationPage.isStatisticsDisplayed());
    }
}
