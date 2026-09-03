package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AdminDashboardPage;
import pageObjects.IntroPageNavigationPage;
import pageObjects.LoginPage;
import utilities.DriverFactory;


public class AdminDashboard {

    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait;
    LoginPage loginPage;

    AdminDashboardPage adminDashboardPage;

    // You must initialize the page object before using it
    public AdminDashboard() {
        this.adminDashboardPage = new AdminDashboardPage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Then("verify user is on Admin Dashboard page")
    public void verifyUserIsOnAdminDashboardPage() {

    }

    @And("Approve the Notice")
    public void approveTheNotice() {
        adminDashboardPage.ApproveNotice();
    }


}
