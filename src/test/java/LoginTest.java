import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;

public class LoginTest {

    private Login login;
    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        driver = new ChromeDriver();
        driver.get("http://mail.ru");
        login = new Login(driver);
    }

    @Test
    public void testLogin() {
        login.login("xxx", "xxx");
    }

    @After
    public void after() {
        driver.close();
    }
}
