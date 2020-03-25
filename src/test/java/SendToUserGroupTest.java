import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login;
import pages.SendToUserGroup;
import pages.ToSpamSending;

import java.util.concurrent.TimeUnit;

public class SendToUserGroupTest {

    private WebDriver driver;
    private Login login;
    private SendToUserGroup sendToUserGroup;
    private static final String LOGIN = "xxx";
    private static final String PASSWORD = "xxx";
    private static final String RECEIVERS = "test1@email.com, test2@email.com, test3@email.com";
    private WebElement lettersSent;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        login = new Login(driver);
        login.login(LOGIN, PASSWORD);
        sendToUserGroup = new SendToUserGroup(driver);
    }

    @Test
    public void sendToGroupTest() {
        sendToUserGroup.sendToGroup(RECEIVERS);
        lettersSent = driver.findElement(By.xpath("//a[@class=\"layer__link\"]"));
        Assert.assertTrue(lettersSent.isDisplayed());
    }

    @After
    public void after() {
        driver.close();
    }
}
