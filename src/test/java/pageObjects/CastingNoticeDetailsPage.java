package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CastingNoticeDetailsPage {
    WebDriver driver;
    private WebDriverWait wait;

    public CastingNoticeDetailsPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    By RoleTitle = By.xpath("//span[text()='test role']");

    public void ClickOnRoleTitle(){
      // driver.findElement(RoleTitle).click();
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(RoleTitle)
        );

        new Actions(driver)
                .scrollToElement(element)
                .perform();

        wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );

        element.click();

    }
}
