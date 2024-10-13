package TestingMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleSearchAutoSuggest {
    public static void main(String[] args) {
         ChromeDriver driver = new ChromeDriver();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Find the search box and enter "ABC"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("ABC");

            // Wait for the auto-suggest dropdown to appear
            // Create a WebDriverWait instance with a timeout of 10 seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//div[@class='aajZCb']")));

            // Capture the suggestions
            List<WebElement> suggestions = driver.findElements(By.xpath
                    ("//ul[@role='listbox']//li//div[@class='wM6y4d']"));

            // Get the size of the suggestions list
            int suggestionsSize = suggestions.size();
            System.out.println("Number of suggestions: " + suggestionsSize);

            // Iterate through the suggestions and print their text
            for (WebElement suggestion : suggestions) {
                System.out.println("Suggestion: " + suggestion.getText());
            }

            // Click on the first suggestion if it exists
            if (suggestionsSize > 0) {
                suggestions.get(0).click();
            }

        } finally {
            // Close the driver
            driver.quit();
        }
    }
}


