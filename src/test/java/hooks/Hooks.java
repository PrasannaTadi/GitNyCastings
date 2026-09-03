package hooks;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.gherkin.model.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.apache.commons.io.FileUtils;
import org.junit.After;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ExtentReportManager;

import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hooks {
    @Before
    public void setUp() {
        ExtentReports extent = ExtentReportManager.getInstance();
        ConfigReader.loadConfig();

        // Launch browser
        DriverFactory.initDriver(ConfigReader.get("browser"));
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
    }
    @Before("@Login")
    public void login(){
        // Login before each scenario
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();
    }



    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    @AfterStep

    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
    }
}
