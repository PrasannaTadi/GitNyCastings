package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class DriverFactory {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Initialize driver based on config
    public static WebDriver initDriver(String Browser) {
        if (tlDriver.get() == null) {
            String browser = ConfigReader.get("browser").toLowerCase();
            int implicitWait = Integer.parseInt(ConfigReader.get("implicitWait"));

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications
                    // Disable Chrome password manager
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);

                    prefs.put("profile.password_manager_leak_detection", false);

                    options.setExperimentalOption("prefs", prefs);

                    tlDriver.set(new ChromeDriver(options));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("permissions.default.desktop-notification", 2); // Block notifications

                    FirefoxOptions optionsff = new FirefoxOptions();
                    optionsff.setProfile(profile);
                    tlDriver.set(new FirefoxDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    Map<String, Object> prefsed = new HashMap<>();
                    prefsed.put("profile.default_content_setting_values.notifications", 2); // Block notifications

                    EdgeOptions optionsed = new EdgeOptions();
                    optionsed.setExperimentalOption("prefs", prefsed);

                    tlDriver.set(new EdgeDriver());
                    break;


                default:
                    throw new IllegalArgumentException("Browser not supported: " + browser);
            }

            WebDriver driver = tlDriver.get();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));

        }

        return tlDriver.get();
    }

    // Get current thread's WebDriver
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // Quit and clean up
    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }
}
