package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Homepage extends BasePage{
    By loginButton = By.xpath("//div[@class=\"gekhq4-4 egoSnI\"]");
    By loginButton2 = By.xpath("//div[@class='sc-12t95ss-3 fDarBX']");
    By searchField = By.xpath("//input[@name='k']");
    By searchButton = By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 gaMakD']");
    By myAccountButton = By.xpath("//div[@class=\"gekhq4-4 egoSnI\"]");
    By favButton = By.xpath("//a[@title=\"Favorilerim\"]");


    public void goToHomepage(WebDriver driver){

        driver.get("https://www.gittigidiyor.com/");
        readyState(driver);

    }

    public void goToLoginPage(WebDriver driver) throws InterruptedException {

        Actions action = new Actions(driver);

        action.moveToElement(driver.findElement(loginButton)).click().build().perform();
        TimeUnit.SECONDS.sleep(1);
        action.moveToElement(driver.findElement(loginButton2)).click().build().perform();

    }

    public void search(WebDriver driver,String input) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        WebElement search = driver.findElement(searchField);
        search.sendKeys(input);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(searchButton)).click().build().perform();

    }

    public void goToFav(WebDriver driver) throws InterruptedException {

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(myAccountButton)).build().perform();
        TimeUnit.SECONDS.sleep(1);
        actions.moveToElement(driver.findElement(favButton)).click().build().perform();

    }
}
