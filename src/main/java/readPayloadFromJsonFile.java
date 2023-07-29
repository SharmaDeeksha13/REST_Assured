import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class readPayloadFromJsonFile {

    @Test
    public void addressAdd() throws IOException {
        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response =   given().header("Content-Type","application/json").queryParam("key","qaclick123").
                body(new String(Files.readAllBytes(Paths.get("C:\\Users\\deeks\\Downloads\\Maven_project\\OctPomSeriesFramework-master\\REST_Assured\\src\\main\\java\\Payload.json")))).
                when().post("maps/api/place/add/json").
                then().log().all().extract().response().asString();

        JsonPath js=new JsonPath(response);
                String scopeValue=js.get("scope");
        Assert.assertEquals("APP",scopeValue);

    }
}
