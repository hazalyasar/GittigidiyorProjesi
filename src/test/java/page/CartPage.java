package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage{
    By quantity = By.xpath("//select[@class=\"amount\"]");
    By confirmButton = By.xpath("//input[@type=\"submit\"]");
    By saveButton = By.xpath("//button[@class=\"gg-ui-btn-primary gg-btn post-address gg-ui-btn-fluid post-address-button gg-ui-btn-lg\"]");
    By editButton = By.xpath("(//a[@class=\"header-link pl10\"])[2]");

    public void quantityUp(WebDriver driver) {

        Select select = new Select(driver.findElement(quantity));
        select.selectByVisibleText("2");

    }

    public void confirmShopping(WebDriver driver){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(confirmButton)).click().build().perform();

    }

    public void saveAddress(WebDriver driver) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(saveButton)).click().build().perform();
        Thread.sleep(2);

    }

    public void editCart(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(editButton)).click().build().perform();

    }
}
