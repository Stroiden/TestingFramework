import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderCallPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тесты для проверки секии Промо на главнй странице
 */
public class MainPageTest extends BaseTest {
    private MainPage mainPage;

    @BeforeClass
    public void prepare() {
      mainPage = new MainPage();
    }

    @Test(testName = "Проверка заголовка главной страницы")
    public void checkHeaderTest() {
        String promoHeader = mainPage.getPromoHeader();

        assertThat(promoHeader)
                .describedAs("Проверка заголовка")
                .isEqualTo("ПОДБОР ПУЛЬСОМЕТРА");
    }

    @Test(dependsOnMethods = "checkHeaderTest", testName = "Проверка открытия модального окна заказа звонка")
    public void modalWindowOpenTest() {
        OrderCallPage orderCallPage = mainPage.openOrderCallPage();

        assertThat(orderCallPage.modalWindowIsOpen())
                .describedAs("Проверка, что модальное окно открыто")
                .isTrue();
    }
}
