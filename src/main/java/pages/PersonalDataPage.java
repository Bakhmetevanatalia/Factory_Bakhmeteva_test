package pages;

import data.AccountData;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.PageObject;
import waiters.StandartWaiter;

import static java.lang.Thread.sleep;

public class PersonalDataPage extends AbsBasePage {

    @FindBy(css = "#id_fname")
    private WebElement ruName;

    @FindBy(css = "#id_lname")
    private WebElement ruSurname;

    @FindBy(css = "#id_fname_latin")
    private WebElement enName;

    @FindBy(css = "#id_lname_latin")
    private WebElement enSurname;

    @FindBy(css = "#id_blog_name")
    private WebElement blogName;

    @FindBy(css = ".input-icon > input:nth-child(1)")
    private WebElement birthday;

    @FindBy(css = "#id_contact-0-value")
    private WebElement habrLogin;

    @FindBy(css = "#id_contact-1-value")
    private WebElement skypeLogin;

    @FindBy(css = ".js-lk-cv-dependent-master > label:nth-child(1) > div:nth-child(2)")
    private WebElement countryButton;

    @FindBy(css = ".js-lk-cv-dependent-slave-city > label:nth-child(1) > div:nth-child(2)")
    private WebElement cityButton;

    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }



    public void fillInData(){
        this.ruName.clear();
        this.ruName.sendKeys(AccountData.ru_name);

        this.ruSurname.clear();
        this.ruSurname.sendKeys(AccountData.ru_surname);

        this.enName.clear();
        this.enName.sendKeys(AccountData.en_name);

        this.enSurname.clear();
        this.enSurname.sendKeys(AccountData.en_surname);

        this.blogName.clear();
        this.blogName.sendKeys(AccountData.blog_name);

        this.birthday.clear();
        this.birthday.sendKeys(AccountData.birthday);

        //country
        this.countryButton.click();
        if (AccountData.country.equals("Россия")) {
            this.driver.findElement(By.cssSelector(".lk-cv-block__select-scroll_country > button:nth-child(2)")).click();
        }

        StandartWaiter sw = new StandartWaiter(driver);
        sw.simpleWait();

        //city
        this.cityButton.click();
        sw.waitForCondition(ExpectedConditions.elementToBeClickable(By.cssSelector(".lk-cv-block__select-scroll_city > button:nth-child(2)")));

        if (AccountData.city.equals("Москва")) {
            this.driver.findElement(By.cssSelector(".lk-cv-block__select-scroll_city > button:nth-child(2)")).click();
        }

        this.habrLogin.clear();
        this.habrLogin.sendKeys(AccountData.login1);

        this.skypeLogin.clear();
        this.skypeLogin.sendKeys(AccountData.login2);
    }

    public void clickSave() {
        driver.findElement(By.cssSelector("button.button_md-4:nth-child(1)")).click();
    }

    public boolean checkData(){
        if (!this.ruName.getAttribute("value").equals(AccountData.ru_name))
            return false;
        if (!this.ruSurname.getAttribute("value").equals(AccountData.ru_surname))
            return false;
        if (!this.enName.getAttribute("value").equals(AccountData.en_name))
            return false;
        if (!this.enSurname.getAttribute("value").equals(AccountData.en_surname))
            return false;
        if (!this.birthday.getAttribute("value").equals(AccountData.birthday))
            return false;
        if (!this.blogName.getAttribute("value").equals(AccountData.blog_name))
            return false;
        if (!this.habrLogin.getAttribute("value").equals(AccountData.login1))
            return false;
        return this.skypeLogin.getAttribute("value").equals(AccountData.login2);
    }
}
