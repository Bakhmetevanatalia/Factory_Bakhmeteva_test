package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    protected Actions actions;
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);

    PageFactory.initElements(driver,this);
    }

}
