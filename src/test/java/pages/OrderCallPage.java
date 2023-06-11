package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderCallPage extends BasePage {

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//div[contains(@class, 'modal__subtitle')]")
    private WebElement modalWindowHeader;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//div[contains(@class, 'modal__descr')]")
    private WebElement modalWindowDescribe;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//input[@name='name']")
    private WebElement modalWindowNameInput;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//input[@name='phone']")
    private WebElement modalWindowPhoneInput;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//input[@name='email']")
    private WebElement modalWindowEmailInput;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//button[contains(@class, 'submit')]")
    private WebElement modalWindowOrderButton;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//div[contains(@class, 'modal__close')]")
    private WebElement modalWindowCloseButton;

    @Step("Получение заголовка модального окна заказа консультации")
    public String getModalWindowHeader() {
       return modalWindowHeader.getText();
    }

    @Step("Получение описания модального окна заказа консультации")
    public String getDescriptionWindow() {
        return modalWindowDescribe.getText();
    }

    @Step("Ввод имени в поле формы модального окна заказа консультации")
    public void enterName(String name) {
        modalWindowNameInput.sendKeys(name);
    }

    @Step("Ввод номера телефона в поле формы модального окна заказа консультации")
    public void enterPhone(String phoneNumber) {
        modalWindowPhoneInput.sendKeys(phoneNumber);
    }

    @Step("Ввод почты в поле формы модального окна заказа консультации")
    public void enterEmail(String email) {
        modalWindowEmailInput.sendKeys(email);
    }
}
