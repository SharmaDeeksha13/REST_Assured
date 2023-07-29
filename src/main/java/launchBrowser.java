import com.sun.deploy.net.protocol.chrome.ChromeURLConnection;
import groovy.transform.Final;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class launchBrowser extends BaseClass{
//    public launchBrowser(WebDriver driver) {
//        super(driver);
//    }
//
    public WebDriver driver;

//    public launchBrowser(WebDriver driver)
//    {
//        super();
//        this.driver=driver;
//    }
//@FindBy(xpath = "//span[text()='New Releases']")
//public WebElement newReleases;

    @Test
    public void execute1() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver","D://Softwares//chromedriver_win32//chromedriver.exe");

        // Headless Execution -

//        ChromeOptions c1= new ChromeOptions();
//        c1.addArguments("--headless");
//        WebDriver driver= new ChromeDriver(c1);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        PageFactory.initElements(driver, BaseClass.class);
        driver.manage().window().maximize();
        Thread.sleep(7000);
//        newReleases.click();
        driver.navigate().back();



//        driver.close();
    }




}
