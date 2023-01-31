package factories;

import data.BrowserData;
import exceptions.BrowserNotSupportedExeption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory implements IFactory {
    private String browserName = System.getProperty("browser.name", "chrome");
    @Override
    public WebDriver createDriver() throws BrowserNotSupportedExeption {
        switch (BrowserData.valueOf(browserName.toUpperCase())) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-fullscreen");
                // only for linux
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                return new ChromeDriver(chromeOptions);
            default:
                throw new BrowserNotSupportedExeption(browserName);
        }
    }

    public static WebDriver create(String webDriverName, String... options)  {
        switch (BrowserData.valueOf(webDriverName.toUpperCase())) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                for (String s : options) {
                    chromeOptions.addArguments(s);
                }
                return new ChromeDriver(chromeOptions);
            default:
                return null;
        }
    }
}
