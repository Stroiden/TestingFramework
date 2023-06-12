package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderCallPage extends BasePage {

    @FindBy(xpath = "//div[contains(@id, 'consultation') and contains(@style, 'display: block')]")
    private WebElement modalWindow;

    @FindBy(xpath = "//div[contains(@id, 'consultation') and contains(@style, 'display: none')]")
    private WebElement hiddenModalWindow;

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

    @FindBy(xpath = "//label[contains(@id, 'name-error')]")
    private WebElement nameError;

    @FindBy(xpath = "//label[contains(@id, 'phone-error')]")
    private WebElement phoneError;

    @FindBy(xpath = "//label[contains(@id, 'email-error')]")
    private WebElement emailError;

    @Step("Получение модального окна")
    public Boolean modalWindowIsOpen() {
       return modalWindow.isDisplayed();
    }

    @Step("Получение модального окна")
    public Boolean modalWindowIsHidden() {
        return hiddenModalWindow.isDisplayed();
    }

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

    @Step("Закрытие модального окна")
    public void closeModalWindow() {
        modalWindowCloseButton.click();
    }

    @Step("Клик по кнопке 'Заказать консультацию'")
    public void pressOrderButton() {
        modalWindowOrderButton.click();
    }

    @Step("Получение текста ошибки поля имени")
    public String getNameErrorText() {
        return nameError.getText();
    }

    @Step("Получение текста ошибки поля телефона")
    public String getPhoneErrorText() {
        return phoneError.getText();
    }

    @Step("Получение текста ошибки поля почты")
    public String getEmailErrorText() {
        return emailError.getText();
    }
}
