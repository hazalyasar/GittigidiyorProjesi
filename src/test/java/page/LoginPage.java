package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage{
    By usernameField = By.id("L-UserNameField");
    By passwordField = By.id("L-PasswordField");
    By loginButton = By.id("gg-login-enter");

    public void login(WebDriver driver, String usernamelocal, String passwordlocal) {

        WebElement username = driver.findElement(usernameField);
        WebElement password = driver.findElement(passwordField);
        Actions actions = new Actions(driver);

        username.sendKeys(usernamelocal);
        password.sendKeys(passwordlocal);
        actions.moveToElement(driver.findElement(loginButton)).click().build().perform();

    }
}
