package components;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsBaseComponent extends PageObject {

    public AbsBaseComponent(WebDriver driver){
        super(driver);
    }
}
