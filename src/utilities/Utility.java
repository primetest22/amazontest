package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Utility extends BaseTest {


    // this method will click on element
    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    //this method will send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }







}
