package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class SearchDell extends Utility {
    String baseUrl = " https://www.amazon.co.uk";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void searcForDellLaptops() throws InterruptedException {
        //accept pop up
        clickOnElement(By.xpath("//input[@id='sp-cc-accept']"));

        //send text to search bar
        sendTextToElement(By.id("twotabsearchtextbox"), "Dell Laptop");

        //click on search button
        clickOnElement(By.id("nav-search-submit-button"));

        //click on dell check box
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));

        Thread.sleep(3000);

        //get number of products displayed on web page
        List<WebElement> names =
                driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        //get total number
        int quantity = names.size();

        //validate quantity
        Assert.assertEquals("Quantity not matching", 30, (quantity));

        Thread.sleep(3000);

        //print all the displayed products names
        List<WebElement> findProducts =
                driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        for (WebElement productNames : findProducts) {
            for (int i = 0; i < findProducts.size(); i++) {
                System.out.println((i + 1) + " " + productNames.getText());
            }
            break;
        }
    }

    @After
    public void tearDown() {
       closeBrowser();
    }
}
