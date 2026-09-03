package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminDashboardPage {
    WebDriver driver;
    private WebDriverWait wait;

    public AdminDashboardPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By approveButton = By.xpath("(//span[@aria-label='Approve'])[1]/button");
    By confirmApproveButton = By.xpath("//div[@role='dialog']//button[normalize-space()='Approve']");

    public void ApproveNotice(){
        WebElement approve = wait.until(
                ExpectedConditions.elementToBeClickable(approveButton)
        );
        approve.click();
       // driver.findElement(approveButton).click();
        // Step 2: Wait for confirmation popup
        WebElement confirmButton = wait.until(
                ExpectedConditions.elementToBeClickable(confirmApproveButton)
        );

        // Step 3: Click APPROVE in confirmation popup
        confirmButton.click();
    }
}
