package HybridFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordDrivenTestingKDT {
    private WebDriver driver;

    public KeywordDrivenTestingKDT() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update path to your WebDriver
        driver = new ChromeDriver();
    }

    public void executeKeyword(String keyword, String locatorType, String locatorValue, String data) {
        switch (keyword.toLowerCase()) {
            case "open":
                driver.get(data);
                break;
            case "input":
                WebElement inputField = findElement(locatorType, locatorValue);
                inputField.sendKeys(data);
                break;
            case "click":
                WebElement button = findElement(locatorType, locatorValue);
                button.click();
                break;
            case "close":
                driver.quit();
                break;
            default:
                System.out.println("Keyword not recognized: " + keyword);
        }
    }

    private WebElement findElement(String locatorType, String locatorValue) {
        switch (locatorType.toLowerCase()) {
            case "id":
                return driver.findElement(By.id(locatorValue));
            case "name":
                return driver.findElement(By.name(locatorValue));
            case "xpath":
                return driver.findElement(By.xpath(locatorValue));
            case "css":
                return driver.findElement(By.cssSelector(locatorValue));
            case "class":
                return driver.findElement(By.className(locatorValue));
            default:
                throw new IllegalArgumentException("Locator type not recognized: " + locatorType);
        }
    }
}
