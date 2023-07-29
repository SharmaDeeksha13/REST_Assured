import SerializationAndDeserilization.POJO_Class;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.*;

public class OAuth2 {
    @Test
    public void data() throws InterruptedException {


//
//        System.setProperty("webdriver.chrome.driver","D://Softwares//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_t" +
//                "ype=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&service=lso&o2v=2&flowName=GeneralOAuthFlow");
//        driver.manage().window().maximize();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//div[text()='Email or phone']//..")).sendKeys("deeksha12december@gmail.com");
//        driver.findElement(By.xpath("//div[text()='Email or phone']//..")).sendKeys(Keys.ENTER);
//
//            Thread.sleep(4000);
//            driver.findElement(By.xpath("//div[text()='Enter your password']//..")).sendKeys("jhumkA@01");
//            driver.findElement(By.xpath("//div[text()='Enter your password']//..")).sendKeys(Keys.ENTER);

// below URL needs to be change after give Email Id and passowrd to the below URL for getting the code-
        //  "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php"
        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AZEOvhUwGsPiit4aTzs5CBwzZol3AglnnUb6znI1po7iFPLg5teKolLXCfdpqyabKknwJA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=3&prompt=none";
        String partialcode = url.split("code=")[1];
        String AuthCode = partialcode.split("&scope")[0];

        System.out.println("AuthCode :" + AuthCode);

        String accessToken = given().urlEncodingEnabled(false).queryParams("code", AuthCode).queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
                queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").
                queryParams("grant_type", "authorization_code").
                when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath js = new JsonPath(accessToken);
        String accessTokenValue = js.getString("access_token");

        System.out.println("Access Token :" + accessTokenValue);


        POJO_Class gc = given().queryParam("access_token", accessTokenValue).expect().defaultParser(Parser.JSON).
                when().get("https://rahulshettyacademy.com/getCourse.php").as(POJO_Class.class);
        System.out.println("Response :" + gc);
        System.out.println("Instructor Name :" + gc.getInstructor());
        System.out.println("Course API Value :" + gc.getCourses().getApi());


//        String authCodeResponse = given().queryParams("scope", "https://www.googleapis.com/auth/userinfo.email").
//                queryParams("auth_url", "https://accounts.google.com/o/oauth2/v2/auth").
//                queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com").
//                queryParams("response_type", "code").queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").
//                when().log().all().post("https://accounts.google.com/o/oauth2/v2/auth").asString();
//
//        JsonPath js1 = new JsonPath(authCodeResponse);
//        String authCode = js1.getString("code");


    }
}
