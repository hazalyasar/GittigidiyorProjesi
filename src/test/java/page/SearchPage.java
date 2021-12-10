package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SearchPage extends BasePage{
    List<String> product = new LinkedList<String>();
    String[] favProduct = new String[4];
    List<Integer> chechkNumber = new ArrayList<Integer>();

    By favori;
    By product8 = By.xpath("(//h2[@class=\"sc-1ku3a4v-0 sc-7u3xly-0 hYkpAn jytHfD sc-1n49x8z-16 iqsmnF\"])[4]");
    By sel = By.xpath("(//button[@class=\"qjixn8-0 sc-1bydi5r-0 dGNqQc pXiHf sc-1n49x8z-3 bhXnM\"])[7]");
    By addButton = By.id("add-to-basket");
    By cartButton = By.xpath("//a[@class=\"dIB\"]");

    Random random = new Random();

    public void collectProducts() {

        for (int i = 0; i < 31; i++) {
            product.add("(//div[@data-cy='product-favorite'])[" + i + "]");
        }

    }

    public void setFavProducts() {

        Integer randomNumber;

        for (int i = 0; i < 4; i++) {

            randomNumber = random.nextInt(31);

            if (chechkNumber.contains(randomNumber) && randomNumber == 0) {

                i--;

            } else {

                favProduct[i] = product.get(randomNumber);
                chechkNumber.add(randomNumber);

            }
            System.out.println(randomNumber);
        }

    }

    public void addFav(WebDriver driver) {

        Actions actions = new Actions(driver);

        for (int i = 0; i < 4; i++) {

            favori = By.xpath(favProduct[i]);

            if (driver.findElement(favori).getLocation() != driver.findElement(By.xpath(favProduct[i])).getLocation()) {

                System.out.println(driver.findElement(By.xpath(favProduct[i])).getLocation());
                actions.moveToElement(driver.findElement(favori)).click().build().perform();
                System.out.println(driver.findElement(favori).getLocation());

            } else {

                i--;

            }

        }

    }

    public void addProduct(WebDriver driver) throws InterruptedException {

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(product8)).click().build().perform();
        Thread.sleep(2);
        scrollDownMid(driver);
        Thread.sleep(2);
        actions.moveToElement(driver.findElement(addButton)).click().build().perform();
        scrollDownMid(driver);
        Thread.sleep(2);

        //Thread.sleep(700);
        //scrollDownMid(driver);
        //actions.moveToElement(driver.findElement(addButton)).click().build().perform();
        //Thread.sleep(700);
        //actions.click().build().perform();

    }

    public void goToCart(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(cartButton)).click().build().perform();

    }
}
