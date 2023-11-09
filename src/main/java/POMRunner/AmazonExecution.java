package POMRunner;

import POMConcepts.page1;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AmazonExecution {

     static WebDriver driver;

    @Test
    public void launch() throws InterruptedException, IOException {
        System.setProperty("webdriver,chrome.driver","D://Softwares//chromedriver_win32//chromedriver.exe");
//        ChromeOptions c1= new ChromeOptions();
//        c1.addArguments("--headless");
//        driver = new ChromeDriver(c1);
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        page1 p1  = PageFactory.initElements(driver,page1.class);
        p1.clickOnGrocery();
        Thread.sleep(3000);
        driver.navigate().back();


       TakesScreenshot tsc= (TakesScreenshot)driver;
      File source= tsc.getScreenshotAs(OutputType.FILE);
        File newDestination= new File("C:\\Users\\deeks\\Downloads\\new1.jpg");
        FileUtils.copyFile(source,newDestination);
        Thread.sleep(3000);

    }

    @Test
    public void launch1() throws InterruptedException, IOException {
        System.setProperty("webdriver,chrome.driver","D://Softwares//chromedriver_win32//chromedriver.exe");
//        ChromeOptions c1= new ChromeOptions();
//        c1.addArguments("--headless");
//        driver = new ChromeDriver(c1);
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        page1 p1  = PageFactory.initElements(driver,page1.class);
        p1.clickOnGrocery();
        Thread.sleep(3000);
        driver.navigate().back();


        TakesScreenshot tsc= (TakesScreenshot)driver;
        File source= tsc.getScreenshotAs(OutputType.FILE);
        File newDestination= new File("C:\\Users\\deeks\\Downloads\\new1.jpg");
        FileUtils.copyFile(source,newDestination);
        Thread.sleep(3000);

    }

    @AfterClass
    public void close()
    {
        driver.close();
    }


}
