package waiters;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StandartWaiter {

    private WebDriver driver;

    public StandartWaiter(WebDriver driver){
        this.driver = driver;
    }

    public void simpleWait(){
        this.waitForCondition(new ExpectedCondition() {
            @NullableDecl
            @Override
            public Object apply(@NullableDecl Object o) {
                return null;
            }
        });
    }

    public boolean waitForCondition(ExpectedCondition condition){
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);

        try{
            webDriverWait.until(condition);
            return true;
        }catch (Exception ignored){
            return false;
        }
    }


}
