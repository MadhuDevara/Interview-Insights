package ModuleTestingFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileModuleTest {
    
    private WebDriver driver;
    
    public ProfileModuleTest(WebDriver driver) {
        this.driver = driver;
    }

    // Function to update user profile information
    public void updateProfile(String newPhone) {
        driver.findElement(By.id("profileTab")).click();
        driver.findElement(By.id("phone")).clear();
        driver.findElement(By.id("phone")).sendKeys(newPhone);
        driver.findElement(By.id("saveProfile")).click();
    }

    // Function to verify profile update success
    public boolean verifyProfileUpdated(String newPhone) {
        String currentPhone = driver.findElement(By.id("phone")).getAttribute("value");
        return currentPhone.equals(newPhone);
    }
}
