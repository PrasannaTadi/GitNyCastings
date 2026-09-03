package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private WebDriverWait wait;

    public HomePage (WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By home = By.xpath("//a[text()='Home']");
    By SignBtn = By.xpath("//button[text()='Sign Out']");
    By unionvalue = By.xpath("//div[contains(@class,'MuiBox-root')]//p[contains(@class,'MuiTypography-noWrap')]");
    By freeTrialText = By.xpath("//span[text()='Free Trial']");

    public boolean isHomeDisplayed() {

        return driver.findElement(home).isDisplayed();
    }
    public void clickonHomepage(){
        driver.findElement(home).click();
    }
    public String getUnion(String expectedUnion){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                unionvalue,
                expectedUnion
        ));

        return driver.findElement(unionvalue).getText().trim();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(SignBtn)
            )).click();
       // driver.findElement(SignBtn).click();
    }
    public boolean isFreeTrialTextDisplayed() {
        return driver.findElement(freeTrialText).isDisplayed();
    }


}
