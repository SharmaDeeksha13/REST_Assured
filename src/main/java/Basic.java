


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Basic {

    public static void main(String[] args) {
        System.out.println("Lets learn REST assured");

        //**********************  ADD Http method***********************

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String Response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body(AddPayload.AddPlace()).
                when().post("maps/api/place/add/json").
                then().assertThat().statusCode(200).body("scope", equalTo("APP")).
                header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        System.out.println("Response :" + Response);

        JsonPath js = new JsonPath(Response);
        String placeID = js.getString("place_id");
        System.out.println("PlaceID :" + placeID);


        //*********************  POST Http Method  ******************************

        String NewAddress = "Humberwood Etobicoke";

       given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body("{\n" +
                        "\"place_id\":\"" + placeID + "\",\n" +
                        "\"address\":\"" + NewAddress + "\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}").
                when().put("maps/api/place/update/json").
                then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated")).extract().response().asString();


        //*******************************    Get Http Method  *****


        String getResponse = given().queryParam("place_id", placeID).queryParam("key", "qaclick123").
                when().get("maps/api/place/get/json").
                then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js2 = new JsonPath(getResponse);
        String updatedAddress = js2.getString("address");
        Assert.assertEquals(updatedAddress,NewAddress);


    }

}
