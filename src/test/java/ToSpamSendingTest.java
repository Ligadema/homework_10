import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.ToSpamSending;

import java.util.concurrent.TimeUnit;

public class ToSpamSendingTest {

    private WebDriver driver;
    private Login login;
    private ToSpamSending toSpam;
    private static final String LOGIN = "xxx";
    private static final String PASSWORD = "xxx";
    private WebElement toSpamResult;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        login = new Login(driver);
        login.login(LOGIN, PASSWORD);
        toSpam = new ToSpamSending(driver);
        toSpamResult = driver.findElement(By.xpath("//div[@title=\"Mail.ru – больше, чем почта. Познакомьтесь с проектами Mail.ru Group\"]"));
    }

    @Test
    public void toSpamTest() {
        toSpam.toSpam();
        Assert.assertFalse(!toSpamResult.isDisplayed());
    }

    @After
    public void after() {
        driver.close();
    }
}
