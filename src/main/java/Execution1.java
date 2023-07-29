import POMConcepts.page1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Execution1 {

    static WebDriver driver;

    @Test
    public void launch() throws InterruptedException {
        System.setProperty("webdriver,chrome.driver","D://Softwares//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        page1 p1  = PageFactory.initElements(driver,page1.class);
        p1.clickOnGrocery();
        Thread.sleep(3000);
        driver.navigate().back();
    }
}
