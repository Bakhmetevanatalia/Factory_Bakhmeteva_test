package factories;

import data.BrowserData;
import exceptions.BrowserNotSupportedExeption;
import org.openqa.selenium.WebDriver;

public interface IFactory {
    WebDriver createDriver() throws BrowserNotSupportedExeption;
}
