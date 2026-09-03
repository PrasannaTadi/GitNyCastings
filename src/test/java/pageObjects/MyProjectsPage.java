package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyProjectsPage {
    WebDriver driver;
    private WebDriverWait wait;
    public MyProjectsPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    By WelcomeText = By.xpath(" //p[text()='Welcome to your DirectSubmit Casting Account.']");
    By searchTalentLink = By.xpath("//a[contains(@class,'disabled-link') and normalize-space()='Search Talent']");
    By createCastingCall= By.xpath("//button[text()='Create New Casting Call']");
    By ProjectTitle= By.name("projectTitle");
    By ProjectDescription = By.name("projectDescription");
    By CastingInfo = By.name("castingOrShootDatesInfo");
    By PayScale = By.name("payScale");
    By AuditionLocation = By.xpath("//div[@id='mui-component-select-auditionLocations']");
    By categoryDropdown = By.xpath("//div[@id='mui-component-select-jobCategories']");
    By castingCallUnionDropdown = By.xpath("//div[@id='mui-component-select-unionStatus']");
    By PayType= By.xpath("//div[@id='mui-component-select-paymentType']");
    By PayValue= By.xpath("//li[text()='No pay']");
    By ExpiredDate = By.xpath("//input[@placeholder='dd-mm-yyyy']");
    By SaveAsDraft= By.xpath("//button[text()='SAVE AS DRAFT']");
    By SaveAndCountinue = By.xpath("//button[text()='SAVE AND CONTINUE']");
    By previewNoticeButtonDisabled = By.xpath("//button[@disabled and normalize-space()='Preview Notice']");
    By RoleCreator = By.xpath("//h6[text()='Create a New Role']");
    By RoleName= By.xpath("//input[@name='roleName']");
    By AgeStart= By.xpath("//input[@name='ageStart']");
    By AgeEnd = By.xpath("//input[@name='ageEnd']");
    By SelectGender = By.xpath("//div[@id='mui-component-select-sex']");
    By SelectGenderValue= By.xpath("//span[text()='Female']");
    By SelectEthnicity = By.xpath("//div[@id='mui-component-select-ethnicity']");
    By SelectEthnicityValue= By.xpath("//span[text()='Latinx']");
    By RoleType = By.xpath("//div[@id='mui-component-select-roleType']");
    By SelectRoleValue= By.xpath("//li[text()='Voice-Over']");
    By SaveRole= By.xpath("//button[text()='Save this Role']");
    By addedRoleTitle(String roleTitle) {
        return By.xpath("//h6//strong[normalize-space()='" + roleTitle + "']");
    }
    By previewNoticeButtonEnabled = By.xpath("//button[normalize-space()='Preview Notice']");
    By PreviewNotice= By.xpath("//button[text()='Preview Notice']");
    By SubmitNotice = By.xpath("//button[text()='Submit Notice']");



    public boolean verifyWelcomeText(){
        return driver.findElement(WelcomeText).isDisplayed();

    }
    public boolean isSearchTalentDisabled() {

        WebElement searchTalent = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchTalentLink)
        );

        String className = searchTalent.getAttribute("class");
        String style = searchTalent.getAttribute("style");

        return className.contains("disabled-link")
                && style.contains("cursor: not-allowed");
    }
    public boolean isSearchTalentNotNavigating() {

        String beforeClick = driver.getCurrentUrl();

        WebElement searchTalent = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchTalentLink)
        );

        searchTalent.click();

        String afterClick = driver.getCurrentUrl();

        return beforeClick.equals(afterClick)
                && !afterClick.contains("/dashboard");
    }
    public void clickOnCreateCastingCall(){
        WebElement CreateNotice = wait.until(
                ExpectedConditions.visibilityOfElementLocated(createCastingCall)
        );
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                CreateNotice
        );

        wait.until(ExpectedConditions.elementToBeClickable(CreateNotice));
        CreateNotice.click();
        //driver.findElement(createCastingCall).click();
    }
    public String AddProjectTitle()
    {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String ProjectTitleName = "Project title_"+ LocalDateTime.now().format(formatter);
        driver.findElement(ProjectTitle).sendKeys(ProjectTitleName);
        return ProjectTitleName;
    }
    public String EnterRolename(){

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String RoleTitle = "AutomationRole_" +
                LocalDateTime.now().format(formatter);
        //driver.findElement(RoleName).sendKeys("Automation Role1");
        driver.findElement(RoleName).sendKeys(RoleTitle);
        return RoleTitle;
    }
    public void AddProjectDecription(String Description){
        driver.findElement(ProjectDescription).sendKeys(Description);
    }
    public void AddCastInfo(String CastInfo){
        driver.findElement(CastingInfo).sendKeys(CastInfo);
    }
    public void AddPayScale(String payscale){
        driver.findElement(PayScale).sendKeys(payscale);
    }
    public String AddLocation(String locationName){
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(AuditionLocation));
        // Scroll dropdown to the center of the viewport
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", dropdown);
        wait.until(ExpectedConditions.elementToBeClickable(AuditionLocation));
        driver.findElement(AuditionLocation).click();
        By locationOption = By.xpath("//span[normalize-space()='" + locationName + "']");
        WebElement location=driver.findElement(locationOption);
        String value=location.getText().trim();
        location.click();
        System.out.println("selected value"+value);
        // Close Material UI dropdown
        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        return value;

    }
    public String AddCategory(String category) {
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Locate Category dropdown
        WebElement dropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(categoryDropdown)
        );

        // Scroll the dropdown to the center
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                dropdown
        );

driver.findElement(categoryDropdown).click();


        // Wait for Material UI listbox
        WebElement listBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[@role='listbox']")
                )
        );

        // Locate requested category
        By optionLocator = By.xpath(
                "//ul[@role='listbox']//li[@role='option']" +
                        "[.//span[normalize-space()='" + category + "']]"
        );

        WebElement option = wait.until(
                ExpectedConditions.visibilityOfElementLocated(optionLocator)
        );

        String selectedCategory = option.getText().trim();

        // Scroll option into view
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                option
        );

        // Click category option
        new Actions(driver)
                .moveToElement(option)
                .pause(Duration.ofMillis(300))
                .click()
                .perform();


        System.out.println("Selected Category: " + selectedCategory);
       // ==================================================
// CLOSE CATEGORY DROPDOWN
// ==================================================

        new Actions(driver)
                .sendKeys(Keys.ESCAPE)
                .perform();

// ==================================================
// SCROLL MAIN PAGE DOWN TO UNION
// ==================================================

        ((JavascriptExecutor) driver).executeScript(
                "window.scrollBy(0, 500);"
        );

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return selectedCategory;
    }
    public String selectCastingCallUnion(String unionName) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Locate Union dropdown
        WebElement unionDropdownElement = wait.until(ExpectedConditions.presenceOfElementLocated(castingCallUnionDropdown));
        driver.findElement(castingCallUnionDropdown).click();
        // SAG-AFTRA option
        By unionOption = By.xpath("//li[@role='option' and @data-value='" + unionName + "']");

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(unionOption));

        String selectedUnion = option.getAttribute("data-value").trim();

        // Scroll option into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", option);
        // Select Union
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

        System.out.println("Selected Union: " + selectedUnion);

        new Actions(driver)
                .sendKeys(Keys.ESCAPE)
                .perform();
        return selectedUnion;
    }
    public void SelectPaytype(){
        driver.findElement(PayType).click();
        // driver.findElement(PayValue).click();
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(PayValue));

        String selectedPay = option.getAttribute("data-value").trim();

        // Scroll option into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", option);
        // Select Union
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);

        System.out.println("Selected paytype: " + selectedPay);

    }
    public void enterdate(){
        driver.findElement(ExpiredDate).sendKeys("11112026");
    }
    public void SaveAsDraft(){
        driver.findElement(SaveAsDraft).click();
    }
    public void SaveAndCountinue(){
        driver.findElement(SaveAndCountinue).click();
    }
    public boolean roleCreatorPageIsDisplayed(){
        return driver.findElement(RoleCreator).isDisplayed();
    }
    public boolean previewNoticeDisabled(){
        return driver.findElement(previewNoticeButtonDisabled).isEnabled();
    }
    public void AddAge(){
        driver.findElement(AgeStart).sendKeys("20");
        driver.findElement(AgeEnd).sendKeys("38");
 }
    public void Selecgender(){
        driver.findElement(SelectGender).click();
     WebElement location=driver.findElement(SelectGenderValue);
     String value=location.getText().trim();
     location.click();
     System.out.println("selected value"+value);
     // Close Material UI dropdown
     driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        //driver.findElement(SelectGenderValue);
 }
    public void SelectEthnicity(){
     driver.findElement(SelectEthnicity).click();
     WebElement location=driver.findElement(SelectEthnicityValue);
     String value=location.getText().trim();
     location.click();
     System.out.println("selected value"+value);
     // Close Material UI dropdown
     driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
     //driver.findElement(SelectEthnicityValue);
 }
    public void SelectRoleType(){
        driver.findElement(RoleType).click();
        WebElement location=driver.findElement(SelectRoleValue);
        String value=location.getText().trim();
        location.click();
        System.out.println("selected value"+value);
        // Close Material UI dropdown
        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
        //driver.findElement(SelectRoleValue);
    }
    public void clickonSaveRole(){
        WebElement roleSave = wait.until(
                ExpectedConditions.presenceOfElementLocated(SaveRole)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(roleSave).perform();

        wait.until(ExpectedConditions.elementToBeClickable(roleSave));

        roleSave.click();
    }
    public boolean isRoleDisplayed(String roleTitle) {

        WebElement role = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        addedRoleTitle(roleTitle)
                )
        );

        return role.isDisplayed();
    }
    public boolean isPreviewNoticeEnabled() {
        return driver.findElement(previewNoticeButtonEnabled).isEnabled();
    }

        public void clickonPreviewNotice(){

        WebElement Preview = wait.until(ExpectedConditions.visibilityOfElementLocated(PreviewNotice));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", Preview);
        wait.until(ExpectedConditions.elementToBeClickable(PreviewNotice));
        driver.findElement(PreviewNotice).click();
    }
    public void clickonSaveSubmitNotice(){
        WebElement NoticeSubmit = wait.until(
                ExpectedConditions.presenceOfElementLocated(SubmitNotice)
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(NoticeSubmit).perform();

        wait.until(ExpectedConditions.elementToBeClickable(NoticeSubmit));

        NoticeSubmit.click();

//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        WebElement Submit = wait.until(ExpectedConditions.visibilityOfElementLocated(SubmitNotice));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", Submit);
//        wait.until(ExpectedConditions.elementToBeClickable(SubmitNotice));
//        driver.findElement(SubmitNotice).click();

    }
    public boolean verifyProjectIsAtTop(String projectTitle) {

        By projectTitleLocator = By.xpath(
                "//span[contains(@class,'MuiTypography-h6')]" +
                        "[contains(normalize-space(.),'" + projectTitle + "')]"
        );


        return driver.findElement(projectTitleLocator).isDisplayed();
    }
    public boolean verifyProjectIsPending(String projectTitle) {

        By pendingStatus = By.xpath(
                "//span[contains(@class,'MuiTypography-h6')]" +
                        "[contains(normalize-space(.),'" + projectTitle + "')]" +
                        "//span[normalize-space()='Pending']"
        );


        return driver.findElement(pendingStatus).isDisplayed();
    }
}
