package pages;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsBasePage extends PageObject {

    private String baseUrl = System.getProperty("base.url","https://otus.ru");
    private String path;

    public AbsBasePage(WebDriver driver, String path){
        super(driver);
        this.path = path;
    }

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(baseUrl + path);

    }

}
