import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestesDeSistema {
    WebDriver webDriver;

    @BeforeAll
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
    }

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterEach
    public void closeDriver() {
        webDriver.close();
    }

    @Test
    public void abrirPaginaTest() {
        webDriver.get("https://github.com/");
        Assertions.assertEquals("https://github.com/", webDriver.getCurrentUrl());
    }

    @Test
    public void abrirPerfilTest() {
        webDriver.get("https://github.com/wallisonwilliam/");
        Assertions.assertEquals("WallisonWilliam (Wallison William) · GitHub", webDriver.getTitle());
    }

}
