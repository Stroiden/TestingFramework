import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.OrderCallPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;

    @BeforeClass
    public void prepare() {
      mainPage = new MainPage();
    }

    @Test
    public void checkHeaderTest() {
        String promoHeader = mainPage.getPromoHeader();

        assertThat(promoHeader)
                .describedAs("Проверка заголовка")
                .isEqualTo("ПОДБОР ПУЛЬСОМЕТРА");
    }

    @Test(dependsOnMethods = "checkHeaderTest")
    public void orderCallModalWindowHeaderTest() {
        OrderCallPage orderCallPage = mainPage.openOrderCallPage();

        assertThat(orderCallPage.getModalWindowHeader())
                .describedAs("Проверка заголовка модального окна")
                .isEqualTo("Просто заполните форму заявки");
    }
}
