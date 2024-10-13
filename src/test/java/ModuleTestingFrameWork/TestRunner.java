package ModuleTestingFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {

    public static void main(String[] args) {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Step 1: Test the Login Module
        LoginModuleTest loginTest = new LoginModuleTest();
        loginTest.launchApplication();
        loginTest.login("testuser", "password123");

        if (loginTest.verifyLoginSuccess()) {
            System.out.println("Login Test Passed");

            // Step 2: Test the Dashboard Module
            DashboardModuleTest dashboardTest = new DashboardModuleTest(driver);
            if (dashboardTest.isDashboardVisible() && dashboardTest.areWidgetsPresent()) {
                System.out.println("Dashboard Test Passed");
            } else {
                System.out.println("Dashboard Test Failed");
            }

            // Step 3: Test the Profile Module
            ProfileModuleTest profileTest = new ProfileModuleTest(driver);
            profileTest.updateProfile("9876543210");
            if (profileTest.verifyProfileUpdated("9876543210")) {
                System.out.println("Profile Test Passed");
            } else {
                System.out.println("Profile Test Failed");
            }

        } else {
            System.out.println("Login Test Failed");
        }

        // Close the application
        loginTest.closeApplication();
    }
}
