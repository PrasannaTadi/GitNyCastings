package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CastingNoticePage {

    WebDriver driver;
    private WebDriverWait wait;
    private String parentWindow;

    public CastingNoticePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By CastingNotices = By.xpath("//a[text()='Casting Notices']");
    By NoticeTitle = By.xpath("//p[text()='Testing text']");
    //"//p[normalize-space()='" + unionName + "']"
    By appliedTag = By.xpath("//span[normalize-space()='Applied']");

    public void ClickOnCastingNotices(){
        driver.findElement(CastingNotices).click();
    }

   public void ClickOnNoticeTitle(){
       // Store the main window before opening child
       parentWindow = driver.getWindowHandle();
        driver.findElement(NoticeTitle).click();
   }

    public void switchToChildWindow(){
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                return;
            }
        }
    }
    public boolean verifyChildWindowOpened() {

        return driver.getWindowHandles().size() > 1;
    }


    public void switchToMainWindow() {

        driver.switchTo().window(parentWindow);
    }
    public boolean verifyAppliedTag() {

        return driver.findElement(appliedTag).isDisplayed();
    }

}
