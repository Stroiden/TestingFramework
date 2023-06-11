import io.github.bonigarcia.wdm.WebDriverManager;;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    @Step("Подготовка для запуска тестов")
    public void setUp() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        BasePage.setDriver(driver);
    }

    @AfterSuite
    @Step("Возврат в исходное состояние")
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}