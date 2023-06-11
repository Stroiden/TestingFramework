package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h1[contains(@class, 'promo__header')]")
    private WebElement promoHeader;

    @FindBy(xpath = "//div[contains(@class, 'header__contacts')]//button")
    private WebElement orderCall;

    public MainPage() {
        driver.get("file:///C:/Users/User/Desktop/front/projects/pulse/index.html#");
    }

    public String getPromoHeader() {
        return promoHeader.getText();
    }

    public OrderCallPage openOrderCallPage() {
        orderCall.click();
        return new OrderCallPage();
    }
}
