package ModuleTestingFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardModuleTest {
    
    private WebDriver driver;
    
    public DashboardModuleTest(WebDriver driver) {
        this.driver = driver;
    }

    // Function to check if dashboard contains critical elements
    public boolean isDashboardVisible() {
        return driver.findElement(By.id("dashboard")).isDisplayed();
    }

    // Function to check whether some widgets are present on the dashboard
    public boolean areWidgetsPresent() {
        return driver.findElements(By.className("widget")).size() > 0;
    }
}
