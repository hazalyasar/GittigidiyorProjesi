package test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger = Logger.getLogger(BaseTest.class);

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

    }

    @After
    public void tearDown() {

        driver.close();
        driver.quit();

    }

}
