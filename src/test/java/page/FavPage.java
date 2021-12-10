package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FavPage extends BasePage{
    ProductPage productPage = new ProductPage();

    List<String> favList = new LinkedList<String>();

    public void addFavList() {

        for (int i = 0; i < 4; i++) {

            favList.add("(//div[@class=\"image-container\"])["+(i+1)+"]");

        }

    }

    public void addToProduct(WebDriver driver) throws InterruptedException {

        Actions actions = new Actions(driver);
        String currentWindow = driver.getWindowHandle();

        for (int i = 0; i < favList.size(); i++) {

            Set<String> windowHandles = driver.getWindowHandles();

            for (String window : windowHandles) {

                actions.moveToElement(driver.findElement(By.xpath(favList.get(i)))).keyDown(Keys.CONTROL).perform();
                TimeUnit.SECONDS.sleep(1);
                actions.click().perform();

                TimeUnit.SECONDS.sleep(1);
                windowHandles = driver.getWindowHandles();
                TimeUnit.SECONDS.sleep(1);
                driver.switchTo().window(window);

                if (!currentWindow.equals(window)) {

                    TimeUnit.SECONDS.sleep(1);
                    //driver.switchTo().window(window);
                    //productPage.addProduct(driver);

                }

            }


            //driver.close();

        }

    }
}
