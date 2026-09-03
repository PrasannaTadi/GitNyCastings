package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    WebDriver driver;
    private WebDriverWait wait;

    public MyAccountPage (WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
By MyAccount= By.xpath("//a[text()='My Account']");
By Creditfield= By.xpath("//label[normalize-space()='Credits']/following-sibling::div//input");


  public void myAccount(){
      driver.findElement(MyAccount).click();
  }
    public String getCredits() {


        WebElement creditElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Creditfield)
        );

        return creditElement
                .getAttribute("value")
                .trim();
    }
}
