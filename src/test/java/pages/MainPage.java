package pages;

import io.qameta.allure.Step;
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

    @Step("Получение заголовка старницы")
    public String getPromoHeader() {
        return promoHeader.getText();
    }

    @Step("Открытие модального окна заказа консультации")
    public OrderCallPage openOrderCallPage() {
        orderCall.click();
        return new OrderCallPage();
    }
}
