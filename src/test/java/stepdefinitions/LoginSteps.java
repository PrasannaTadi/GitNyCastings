package stepdefinitions;



import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;
import utilities.DriverFactory;

public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage;

    public LoginSteps(){
        this.loginPage= new LoginPage(driver);

    }

    @Given("User is on login page")
    public void user_is_on_login_page() {

        System.out.println("Login page is already opened");
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        loginPage.verifyLoginSuccessful();

        System.out.println("Login successful");
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }



//    @And("User clicks login button")
//    public void user_clicks_login_button() {
//        loginPage.clickLogin();
//    }

    @Then("User should be navigated to the home page")
    public void user_should_be_navigated_to_the_home_page() {
        loginPage.verifyHomePage();
    }

    @Given("User is on dashboard")
    public void userIsOnDashboard() {
        System.out.println("Dashboard");
        // Hooks.test.get().info("Navigated to https://example.com");
    }

    @Then("User should see home page")
    public void userShouldSeeHomePage() {
        System.out.println("Homepage");
    }


    @Then("verify user is on Dashboard page")
    public void verifyUserIsOnDashboardPage() {

    }

    @When("login as a Admin")
    public void loginAsAAdmin() {
        loginPage.enterUsername("Lakshmi");
        loginPage.enterPassword("Test@123");
        loginPage.clickLogin();

    }
}

