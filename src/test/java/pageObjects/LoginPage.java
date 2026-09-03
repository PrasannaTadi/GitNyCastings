package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginBtn= By.xpath("//button[text()='Login']");


    public boolean isLoginPageDisplayed() {
        return wait.until(
                ExpectedConditions.urlContains("/login")
        );}
    public void enterUsername(String username) {
        WebElement usernameElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.click();
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {

        WebElement passwordElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordField));

        wait.until(
                ExpectedConditions.elementToBeClickable(passwordElement)
        );
        passwordElement.click();
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(loginBtn)
        );

        driver.findElement(loginBtn).click();
    }

    public void verifyHomePage() {
        // Assertion logic here
    }
    public void verifyLoginSuccessful() {

        wait.until(ExpectedConditions.urlContains("/dashboard"));
    }
}
