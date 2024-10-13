package TestAutomationFrameworks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BehaviorDrivenDevelopmentBDD {
    WebDriver driver;

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
    }

    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        driver.findElement(By.id("username")).sendKeys("validUser");
        driver.findElement(By.id("password")).sendKeys("validPassword");
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("The user is redirected to the dashboard")
    public void the_user_is_redirected_to_the_dashboard() {
        String dashboardURL = driver.getCurrentUrl();
        assert(dashboardURL.equals("https://example.com/dashboard"));
        driver.quit();
    }

    @When("The user enters invalid credentials")
    public void the_user_enters_invalid_credentials() {
        driver.findElement(By.id("username")).sendKeys("invalidUser");
        driver.findElement(By.id("password")).sendKeys("invalidPassword");
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("The user should see an error message")
    public void the_user_should_see_an_error_message() {
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();
        assert(errorMessage.equals("Invalid username or password"));
        driver.quit();
    }

}
