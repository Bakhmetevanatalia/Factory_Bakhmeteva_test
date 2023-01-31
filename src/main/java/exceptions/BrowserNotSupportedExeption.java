package exceptions;

public class BrowserNotSupportedExeption extends Exception{
    public BrowserNotSupportedExeption(String browserName){
        super(String.format("Browser %s is not supported!",browserName));
    }
}
