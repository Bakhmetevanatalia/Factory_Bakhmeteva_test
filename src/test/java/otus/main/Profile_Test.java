package otus.main;

import components.LoginWindow;
import data.AccountData;
import data.BrowserData;
import exceptions.BrowserNotSupportedExeption;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.PersonalDataPage;

public class Profile_Test {

    private WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() throws BrowserNotSupportedExeption {
        driver = new WebDriverFactory().createDriver();
    }

    @AfterEach
    public void close(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void checkProfileInfo() throws InterruptedException {

        // Log in to the site
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.loginAndGoToPersonalPage(AccountData.login, AccountData.pass);

        // In the "About me" section, fill in all the "Personal data" fields and add at least two contacts
        // going directly to "about me" part
        PersonalDataPage personalDataPage = new PersonalDataPage(driver);
        personalDataPage.fillInData();
        personalDataPage.clickSave();

        // Open https://otus.ru in a "clean browser"
        WebDriver cleanDriver = WebDriverFactory.create(BrowserData.CHROME.getName());

        // Log in to the site
        loginWindow = new LoginWindow(cleanDriver);
        loginWindow.loginAndGoToPersonalPage(AccountData.login, AccountData.pass);

        // Check that the previously specified data is displayed in the "About me" section
        PersonalDataPage p1 = new PersonalDataPage(cleanDriver);
        Assertions.assertTrue(p1.checkData());

        cleanDriver.close();
    }
}
