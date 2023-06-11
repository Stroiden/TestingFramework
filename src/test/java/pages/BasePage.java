package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected static WebDriver driver;

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
