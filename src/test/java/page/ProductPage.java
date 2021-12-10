package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    By product = By.xpath("//ul[@class=\"sp-specOption\"]/li");
    By addButton = By.xpath("//button[@id=\"add-to-basket\"]");

    public void addProduct(WebDriver driver) throws InterruptedException {

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//ul[@class=\"sp-specOption\"]/li"))).click().build().perform();
        TimeUnit.SECONDS.sleep(2);
        actions.moveToElement(driver.findElement(By.xpath("//button[@id=\"add-to-basket\"]"))).click().build().perform();

    }
}
