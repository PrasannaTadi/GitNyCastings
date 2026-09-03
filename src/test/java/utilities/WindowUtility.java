package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowUtility {
    public static void switchToNewTab(WebDriver driver) {
        String current = driver.getWindowHandle();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        Set<String> handles = driver.getWindowHandles();
        List<String> handleList = new ArrayList<>(handles);

        // Switch to the last handle (newest tab)
        String newestHandle = handleList.get(handleList.size() - 1);
        if (!newestHandle.equals(current)) {
            driver.switchTo().window(newestHandle);
        }
    }
}
