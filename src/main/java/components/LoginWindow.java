package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import waiters.StandartWaiter;


public class LoginWindow extends AbsBaseComponent {

    @FindBy(css = "div.new-input-line_last:nth-child(5) > button:nth-child(1)")
    private WebElement submit;

    @FindBy(css = ".header3__button-sign-in")
    private WebElement login;



    public LoginWindow(WebDriver driver) {
        super(driver);
        new MainPage(driver).open();
    }

    public void loginAndGoToPersonalPage(String email, String password) throws InterruptedException {
        login.click();
        StandartWaiter sw = new StandartWaiter(driver);
        sw.simpleWait();

        driver.findElement(By.cssSelector("form.new-log-reg__form > div:nth-child(3) > input:nth-child(1)")).sendKeys(email);
        driver.findElement(By.cssSelector(".new-input_password")).sendKeys(password);

        clickSubmit();
        sw.simpleWait();

        driver.findElement(By.cssSelector(".header3__user-info-name")).click();
        driver.findElement(By.cssSelector("[href*='/lk/biography/personal']")).click();

    }

    private void clickSubmit() {
        submit.click();
    }
}

