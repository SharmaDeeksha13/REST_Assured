import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdvanceAPI {

    @Test(dataProvider = "dataProv")
    public void Book(String isbn, String aisle) {
      RestAssured.baseURI="http://216.10.245.166/";
      String addBookResponse=  given().header("Content-Type","application/json").body(AddPayload.libraryAdd(isbn, aisle)).
                when().post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).body("Msg",equalTo("successfully added")).extract().response().asString();

        JsonPath js= new JsonPath(addBookResponse);
        String id=js.get("ID");
        System.out.println("ID is : "+ id);


    }

    @DataProvider(name="dataProv")
    public Object[][] getData()
    {
       return new Object[][] {{"aabba","111"},{"baaabb","222"},{"ccxxxc","333"}};
    }
}
