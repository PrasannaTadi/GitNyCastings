package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.IntroPageNavigationPage;
import pageObjects.MyAccountPage;
import utilities.DriverFactory;

public class MyAccountSteps {
    WebDriver driver = DriverFactory.getDriver();
    IntroPageNavigationPage introPageNavigationPage;
    MyAccountPage myAccountPage;
    private WebDriverWait wait;

    // You must initialize the page object before using it
    public MyAccountSteps() {
      this.myAccountPage= new MyAccountPage(driver);
    }



    @Then("Verify credits value is displayed as {string}")
    public void verifyCreditsValueIsDisplayedAs(String expectedCredits) {
        myAccountPage.myAccount();
        String actualCredits = myAccountPage.getCredits();
        System.out.println("Expected Credits: " + expectedCredits);
        System.out.println("Actual Credits: " + actualCredits);
        Assert.assertEquals(expectedCredits, actualCredits);
    }

    }
