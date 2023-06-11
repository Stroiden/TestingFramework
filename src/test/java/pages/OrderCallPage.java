package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderCallPage extends BasePage {

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//div[contains(@class, 'modal__subtitle')]")
    private WebElement modalWindowHeader;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//div[contains(@class, 'modal__descr')]")
    private WebElement modalWindowDescribe;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//input[@name='name']")
    private WebElement modalWindowName;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//input[@name='phone']")
    private WebElement modalWindowPhone;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//input[@name='email']")
    private WebElement modalWindowEmail;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//button[contains(@class, 'submit')]")
    private WebElement modalWindowOrderButton;

    @FindBy(xpath = "//div[contains(@id, 'consultation')]//div[contains(@class, 'modal__close')]")
    private WebElement modalWindowCloseButton;

    public String getModalWindowHeader() {
       return modalWindowHeader.getText();
    }
}
