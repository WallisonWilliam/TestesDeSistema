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
    public void abrirPaginaTest() throws InterruptedException {
        webDriver.get("https://github.com/");
        Thread.sleep(2000);
        Assertions.assertEquals("https://github.com/", webDriver.getCurrentUrl());
    }

    @Test
    public void abrirPerfilTest() throws InterruptedException {
        webDriver.get("https://github.com/wallisonwilliam/");
        Thread.sleep(2000);
        Assertions.assertEquals("WallisonWilliam (Wallison William) · GitHub", webDriver.getTitle());
    }

    @Test
    public void pesquisarPerfilTest() throws InterruptedException {
        webDriver.get("https://github.com");
        webDriver.findElement(By.xpath("//*[@class=\"form-control header-search-wrapper input-sm p-0 js-chromeless-input-container header-search-wrapper-jump-to position-relative d-flex flex-justify-between flex-items-center\"]")).sendKeys("Wallison William", Keys.ENTER);
        Thread.sleep(2000);
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("/search?q=Wallison+William"), webDriver.getCurrentUrl());
    }

    @Test
    public void abrirRepositorioTest() throws InterruptedException {
        webDriver.get("https://github.com/search?q=WallisonWilliam");
        webDriver.findElement(By.xpath("//*[@class=\"v-align-middle\"]")).click();
        Thread.sleep(2000);
        Assertions.assertEquals("https://github.com/WallisonWilliam/WallisonWilliam", webDriver.getCurrentUrl());
    }
}
