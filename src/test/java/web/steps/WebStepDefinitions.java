package web.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebStepDefinitions {

    private WebDriver driver;

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        WebDriverManager.chromedriver().setup();
        // Gunakan headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String buttonText) {
        WebElement button = driver.findElement(By.linkText(buttonText));
        button.click();
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("loginusername")).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("I should see the welcome message {string}")
    public void iShouldSeeTheWelcomeMessage(String expectedMessage) {
        WebElement welcomeMessage = driver.findElement(By.id("nameofuser"));
        assertEquals(expectedMessage, welcomeMessage.getText());
        driver.quit();
    }
}
