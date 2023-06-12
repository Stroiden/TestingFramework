import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderCallPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для проверки модального окна заказа звонка/консультации
 */
public class OrderCallModalWindowTest extends BaseTest {

    private OrderCallPage orderCallPage;

    @BeforeClass
    public void prepare() {
        orderCallPage = new MainPage().openOrderCallPage();
    }

    @Test(testName = "Проверка заголовка модального окна")
    public void orderCallModalWindowHeaderTest() {
        assertThat(orderCallPage.getModalWindowHeader())
                .describedAs("Проверка заголовка модального окна")
                .isEqualTo("Просто заполните форму заявки");
    }

    @Test(dependsOnMethods = "orderCallModalWindowHeaderTest", testName = "Проверка подзаголовка модального окна")
    public void orderCallModalWindowDescriptionTest() {
        assertThat(orderCallPage.getDescriptionWindow())
                .describedAs("Проверка подзаголовка модального окна")
                .isEqualTo("и мы перезвоним вам в течении 10 минут");
    }

    @Test(dependsOnMethods = "orderCallModalWindowDescriptionTest", testName = "Проверка закрытия модального окна")
    public void closeModalWindowTest() {
        orderCallPage.closeModalWindow();

        assertThat(orderCallPage.modalWindowIsHidden())
                .describedAs("Проверка, что модальное окно закрыто")
                .isFalse();
    }

    @Test(dependsOnMethods = "closeModalWindowTest", testName = "Заказ звонка без заполнения обязательных полей")
    public void orderCallWithoutFillingRequiredFieldsTest() {
        orderCallPage = new MainPage().openOrderCallPage();
        orderCallPage.pressOrderButton();

        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(orderCallPage.getNameErrorText())
                    .describedAs("Проверка текста сообщения об ошибке в поле имени")
                    .isEqualTo("Пожалуйста, введите свое имя");

            softAssertions.assertThat(orderCallPage.getPhoneErrorText())
                    .describedAs("Проверка текста сообщения об ошибке в поле телефон")
                    .isEqualTo("Пожалуйста, введите свой номер телефона");

            softAssertions.assertThat(orderCallPage.getEmailErrorText())
                    .describedAs("Проверка текста сообщения об ошибке в поле почты")
                    .isEqualTo("Пожалуйста, введите свою почтs");
        });
    }
}
