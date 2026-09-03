package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IntroPageNavigationPage {
    WebDriver driver;
    private WebDriverWait wait;
    public IntroPageNavigationPage(WebDriver driver) {
        this.driver = driver;

    }

    By IntoBtn= By.xpath("//img[@alt='DirectSubmit']");
    By IntroBtn= By.xpath("//a[@class='nav-logo']");
    By logo = By.xpath("//img[contains(@alt,'DirectSubmit')]");
    By iamTalent = By.xpath("//span[text()='I AM TALENT']");
    By castingDirector = By.xpath("//span[text()='I’M A CASTING DIRECTOR']");
    By toggle = By.xpath("//span[contains(@class,'MuiSwitch-root')]//input[@type='checkbox']");
    By startFreeTrial = By.xpath("//a[text()='Start Free Trial']");
    By seeTodayCastingCalls = By.xpath("//a[text()='See Today’s Casting Calls']");
    By heading = By.xpath("//h1[text()='Direct. Submit. ']");
    By description = By.xpath("//*[contains(text(),'Find casting calls')]");
    By statistics = By.xpath("//button[contains(text(),'START FREE TRIAL')]");
    //div[text()='26+']




    public void verifyClickingOnIntroPage()
    {
        driver.findElement(IntroBtn).click();
    }
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }
    public boolean isIamTalentDisplayed() {
        return driver.findElement(iamTalent).isDisplayed();
    }
    public boolean isCastingDirectorDisplayed() {
        return driver.findElement(castingDirector).isDisplayed();
    }
    public boolean toggleButtonDisplayed() {
        return driver.findElement(toggle).isDisplayed();
    }

    public boolean isStartTrialDisplayed() {


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement button = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(startFreeTrial));

            return button.isDisplayed();

    }
    public boolean isTodayCastingCallButtonDisplayed() {
        return driver.findElement(seeTodayCastingCalls).isDisplayed();
    }
    public boolean isHeadingDisplayed() {
        return driver.findElement(heading).isDisplayed();
    }
    public String getHeroDescription() {
        return driver.findElement(description).getText().trim();
    }
    public boolean isStatisticsDisplayed() {
        return driver.findElement(statistics).isDisplayed();
    }



}
