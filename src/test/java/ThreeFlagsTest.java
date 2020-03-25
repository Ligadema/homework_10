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
import pages.ThreeFlags;

import java.util.concurrent.TimeUnit;

public class ThreeFlagsTest {

    private WebDriver driver;
    private Login login;
    private static final String LOGIN = "xxx";
    private static final String PASSWORD = "xxx";
    private ThreeFlags markLetters;
    private WebElement letterFirstFlag;
    private WebElement letterSecondFlag;
    private WebElement letterThirdFlag;

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
        markLetters = new ThreeFlags(driver);
        markLetters.flagLetterOne();
        letterFirstFlag = driver.findElement(By.xpath("//span[@title=\"Снять флажок\"]"));
        Assert.assertTrue(letterFirstFlag.isDisplayed());
    }

    @Test
    public void flagLetterTwoTest() {
        markLetters = new ThreeFlags(driver);
        markLetters.flagLetterTwo();
        letterSecondFlag = driver.findElement(By.xpath("//span[@title=\"Снять флажок\"]"));
        Assert.assertTrue(letterSecondFlag.isDisplayed());
    }

    @Test
    public void flagLetterThreeTest() {
        markLetters = new ThreeFlags(driver);
        markLetters.flagLetterThree();
        letterThirdFlag = driver.findElement(By.xpath("//span[@title=\"Снять флажок\"]"));
        Assert.assertTrue(letterThirdFlag.isDisplayed());
    }

    @After
    public void after() {
        driver.close();
    }
}
