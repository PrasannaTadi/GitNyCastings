package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {
    WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By joinNow = By.xpath("//a[text()='Join Now']");
    By fullName = By.name("fullName");
    By unionDropdown = By.xpath("//div[@role='combobox']");
    By unionValue = By.xpath("//p[text()='SAG-AFTRA']");
    By email = By.name("email");
    By username = By.name("username");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By terms = By.xpath("//p[contains(normalize-space(.),'I agree to the')]/preceding-sibling::span");
    By signupBtn = By.xpath("//button[@type='submit']");
    By CastingDirector= By.xpath("//button[text()='Casting Director / Creator']");
    By Companyname = By.name("companyName");
    By PhoneNumber = By.name("phoneNumber");
    //input[@name='phoneNumber']




    public void clickJoinNow() {
        driver.findElement(joinNow).click();
    }
    public void enterFullName(String name){
        driver.findElement(fullName).sendKeys(name);
    }
    public String selectUnion(String unionName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Locate Union dropdown
        WebElement unionDropdownElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(unionDropdown)
        );

        // Scroll Union dropdown into view
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                unionDropdownElement
        );

        // Wait until visible
        wait.until(
                ExpectedConditions.visibilityOf(unionDropdownElement)
        );

        // Click Union dropdown
        new Actions(driver)
                .moveToElement(unionDropdownElement)
                .pause(Duration.ofMillis(300))
                .click()
                .perform();

        // Locate Union option
        By unionOption = By.xpath(
                "//p[normalize-space()='" + unionName + "']"
        );

        WebElement union = wait.until(
                ExpectedConditions.visibilityOfElementLocated(unionOption)
        );

        String value = union.getText().trim();

        // Scroll option into view
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                union
        );

        // Select Union
        new Actions(driver)
                .moveToElement(union)
                .pause(Duration.ofMillis(300))
                .click()
                .perform();

        System.out.println("selected value" + value);

        // Close Material UI dropdown
        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);

        return value;
    }

    public void enterEmail(String emailId){

        driver.findElement(email).sendKeys(emailId);
    }
    public String enterUsername(){

        String usernameValue="User"+System.currentTimeMillis();

        driver.findElement(username).sendKeys(usernameValue);

        return usernameValue;

    }
    public String enterPassword(){

        String pwd="Test@1234";

        driver.findElement(password).sendKeys(pwd);

        return pwd;

    }
    public void confirmPassword(String pwd){

        driver.findElement(confirmPassword).sendKeys(pwd);

    }
    public void clickTerms(){

        WebElement checkbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(terms)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkbox);

    }
    public void clickSignUp(){


        //driver.findElement(signupBtn).click();
        WebElement checkbox = wait.until(
                ExpectedConditions.presenceOfElementLocated(signupBtn)
        );

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkbox);

    }
 public void clickOnDirectorbutton(){
        driver.findElement(CastingDirector).click();
 }
    public void enterCompanyName(String name){
        driver.findElement(Companyname).sendKeys(name);
    }

    public void enterPhoneNumber(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement phoneField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(PhoneNumber)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                phoneField
        );

        wait.until(ExpectedConditions.elementToBeClickable(phoneField));

        new Actions(driver)
                .moveToElement(phoneField)
                .click()
                .perform();

        // Re-find because React may rerender after focus
        phoneField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(PhoneNumber)
        );

        phoneField.sendKeys(Keys.CONTROL, "a");
        phoneField.sendKeys(name);
    }

public void SelectUnionValues(String union){
       Select select = new Select(driver.findElement(unionDropdown));
       select.selectByVisibleText(union);
}

}