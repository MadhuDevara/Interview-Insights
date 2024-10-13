package TestingMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FontTest {
    public static void main(String[] args){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/in/");

        //Find element to find css font properties
        WebElement element = driver.findElement(By.cssSelector("button[data-uia='nmhp-card-cta+hero_card']"));
        String fontFamily = element.getCssValue("font-family");
        String fontSize = element.getCssValue("font-size");

        System.out.println("Font Family" + fontFamily);
        System.out.println("Font Size" + fontSize);

        //Validate the font family and size
        if(fontFamily.contains("Netflix Sans")){
            System.out.println("Font family is correct");
        }else{
            System.out.println("Font family is incorrect");
        }

        if(fontSize.contains("18px")){
            System.out.println("Font size is correct.");
        }else{
            System.out.println("Font size is incorrect");
        }

        driver.quit();

    }
}
