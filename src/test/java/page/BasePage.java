package page;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import test.BaseTest;

public class BasePage extends BaseTest {

    public void readyState(WebDriver driver) {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String readyState = javascriptExecutor.executeScript("return document.readyState").toString();

        Assert.assertEquals(readyState,"complete");
        logger.info("Anasayfa Açıldı");

    }

    public void scrollDown(WebDriver driver) {

        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }

    public void scrollDownMid(WebDriver driver) {

        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("window.scrollBy(0,250)");

    }

}
