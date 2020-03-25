import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CancelThreeFlags;
import pages.Login;

import java.util.concurrent.TimeUnit;

public class CancelThreeFlagsTest {

    private WebDriver driver;
    private Login login;
    private static final String LOGIN = "xxx";
    private static final String PASSWORD = "xxx";
    private CancelThreeFlags unmarkLetters;
    private WebElement letterFirstFlagDelete;
    private WebElement letterSecondFlagDelete;
    private WebElement letterThirdFlagDelete;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "../../chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        login = new Login(driver);
        login.login(LOGIN, PASSWORD);
    }

    @Test
    public void flagLetterOneTest() {
        unmarkLetters = new CancelThreeFlags(driver);
        unmarkLetters.unflagLetterOne();
        letterFirstFlagDelete = driver.findElement(By.xpath("//span[@title=\"Пометить флажком\"]"));
        Assert.assertTrue(letterFirstFlagDelete.isDisplayed());
    }

    @Test
    public void flagLetterTwoTest() {
        unmarkLetters = new CancelThreeFlags(driver);
        unmarkLetters.unflagLetterTwo();
        letterSecondFlagDelete = driver.findElement(By.xpath("//span[@title=\"Пометить флажком\"]"));
        Assert.assertTrue(letterSecondFlagDelete.isDisplayed());
    }

    @Test
    public void flagLetterThreeTest() {
        unmarkLetters = new CancelThreeFlags(driver);
        unmarkLetters.unflagLetterThree();
        letterThirdFlagDelete = driver.findElement(By.xpath("//span[@title=\"Пометить флажком\"]"));
        Assert.assertTrue(letterThirdFlagDelete.isDisplayed());
    }

    @After
    public void after() {
        driver.close();
    }
}
