package POMConcepts;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class page1 {

    public WebDriver driver;

    {
        this.driver = driver;

    }

    @FindBy(xpath = "//span[text()='& Orders']")
    public WebElement orders;


    public void clickOnGrocery() {
        orders.click();
    }

//    @After
//    public void closeBrowser1() {
//        driver.close();
//    }


}
