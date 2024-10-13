package TestingMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ColorTest {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        //Find element and get CSS colour property
        WebElement element = driver.findElement(By.className("lnXdpd"));
        String colour = element.getCssValue("colour");
        System.out.println("Element colour" + colour);

        //validate if the colour Matches expected (You can use RGB,HEX)
        if(colour.equals("rgba(255, 255, 255, 1)")){   // Example of checking for white
               System.out.println("Colour is correct");
        }else{
            System.out.println("Colour is incorrect");
        }



    }
}
