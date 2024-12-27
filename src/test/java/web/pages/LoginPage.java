package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By loginButton = By.linkText("Log in");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By submitButton = By.xpath("//button[text()='Log in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(submitButton).click();
    }
}
