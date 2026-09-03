package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utilities.ContextKeys;
import utilities.DriverFactory;
import utilities.ScenarioContext;

import java.time.Duration;

public class SignUpSteps {
    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait;
  SignUpPage signUpPage;
  LoginPage loginPage;
  HomePage homePage;

    public SignUpSteps(){
        this.signUpPage= new SignUpPage(driver);
        this.loginPage = new LoginPage(driver);
        this.homePage= new HomePage(driver);

    }

    @Then("click on JoinNow")
    public void clickOnJoinNow() {
        signUpPage.clickJoinNow();
    }

    @And("user enter fullName")
    public void userEnterFullName() {
        signUpPage.enterFullName("Lakshmi Role Preference");
    }


//    @And("User select the union value from dropdown and store the value")
//    public void userSelectTheUnionValueFromDropdownAndStoreTheValue() {
//        String union=signUpPage.selectUnion();
//        System.out.println("Selected Union during Signup: " + union);
//        ScenarioContext.set(ContextKeys.UNION,union);
//        System.out.println("Selected Union during Signup: " + union);
//    }
    @Then("Select union {string} from dropdown and store the value")
    public void selectUnionFromDropdownAndStoreTheValue(String unionvalue) {
        String selectedUnion = signUpPage.selectUnion(unionvalue);

        ScenarioContext.set(ContextKeys.UNION, selectedUnion);

        System.out.println("Selected Union: " + selectedUnion);
    }

    @And("User enters aunique email id")
    public void userEntersAuniqueEmailId() {
        signUpPage.enterEmail("lakshmi"+System.currentTimeMillis()+"@mailinator.com");
    }


    @Then("User enters username and Password and Store username and password")
    public void userEntersUsernameAndPasswordAndStoreUsernameAndPassword() {
        String username=signUpPage.enterUsername();

        String password=signUpPage.enterPassword();
        System.out.println("Generated Username: " + username);
        System.out.println("Generated Password: " + password);

        ScenarioContext.set(ContextKeys.USERNAME,username);

        ScenarioContext.set(ContextKeys.PASSWORD,password);
    }

    @Then("User enters confirm password")
    public void userEntersConfirmPassword() {
        String password=(String)ScenarioContext.get(ContextKeys.PASSWORD);

        signUpPage.confirmPassword(password);

    }

    @And("Enable the Terms and conditions Check box")
    public void enableTheTermsAndConditionsCheckBox() {
        signUpPage.clickTerms();
    }

    @Then("User click on SignUp button")
    public void userClickOnSignUpButton() {
        signUpPage.clickSignUp();
    }

    @Then("User login the application with Created username and password")
    public void userLoginTheApplicationWithCreatedUsernameAndPassword() {
        Assert.assertTrue( loginPage.isLoginPageDisplayed());

        String username=(String)ScenarioContext.get(ContextKeys.USERNAME);

        String password=(String)ScenarioContext.get(ContextKeys.PASSWORD);


        System.out.println("Retrieved Username: " + username);
        System.out.println("Retrieved Password: " + password);
        //loginPage.enterUsername(username);

        loginPage.enterPassword(password);

        loginPage.clickLogin();
    }

    @Then("Verify user is on Home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(homePage.isHomeDisplayed());
        homePage.clickonHomepage();


    }

    @And("Verify selected Union value is displayed")
    public void verifySelectedUnionValueIsDisplayed() {

        String expected=(String)ScenarioContext.get(ContextKeys.UNION);

        String actual=homePage.getUnion(expected);

        Assert.assertEquals(expected,actual);

    }

    @And("click on logout button")
    public void clickOnLogoutButton() {
        homePage.clickLogout();
    }


    @And("Verify the FreeTrail label is displayed")
    public void verifyTheFreeTrailLabelIsDisplayed() {
        Assert.assertTrue(homePage.isFreeTrialTextDisplayed());
    }


    @And("click on casting directors")
    public void clickOnCastingDirectors() {
        signUpPage.clickOnDirectorbutton();
    }

    @And("User enter the companyname")
    public void userEnterTheCompanyname() {
        signUpPage.enterCompanyName("TestCompany");

    }

    @And("User enter the phonenumber")
    public void userEnterThePhonenumber() {
        signUpPage.enterPhoneNumber("2323232323");
    }

    @Then("enter Username")
    public void enterUsername() {
        loginPage.enterUsername("PrasannaP1");
    }

    @Then("enter password")
    public void enterPassword() {
        loginPage.enterPassword("Test@1234");
    }

    @Then("click on login button")
    public void clickOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("Select the union value {string}")
    public void selectTheUnionValue(String union) {
        signUpPage.SelectUnionValues(union);
    }
}
