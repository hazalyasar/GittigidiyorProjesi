package test;

import org.junit.Test;
import page.*;

public class Gittigiyor extends BaseTest{

    Homepage homepage = new Homepage();
    LoginPage loginPage = new LoginPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    FavPage favpage = new FavPage();


    @Test
    public void testCase1() throws InterruptedException {

        homepage.goToHomepage(driver);
        homepage.goToLoginPage(driver);
        loginPage.login(driver,"cantanya85@gmail.com","1234567h");
        homepage.search(driver,"Ruj");
        searchPage.scrollDown(driver);
        searchPage.collectProducts();
        searchPage.setFavProducts();
        searchPage.addFav(driver);
        homepage.goToHomepage(driver);
        homepage.search(driver, "Çanta");
        searchPage.addProduct(driver);
        searchPage.goToCart(driver);
        cartPage.quantityUp(driver);
        cartPage.confirmShopping(driver);
        cartPage.saveAddress(driver);
        cartPage.editCart(driver);
        homepage.goToHomepage(driver);
        homepage.goToFav(driver);
        favpage.addFavList();
        favpage.addToProduct(driver);
    }
}
