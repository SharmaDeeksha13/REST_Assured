import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJSONRequest {

    public static void main(String[] args) {
        JsonPath js = new JsonPath(AddPayload.courseDetails());  // Mocked the response(Dummy response we hard coded) because API is not ready

//Task 1 Print No of courses returned by API

        int totalCourseCount = js.getInt("courses.size()");
        System.out.println("Total Course present is : " + totalCourseCount);


        // Task2 : Print Purchase amount

        int purchaseAmount = js.get("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        // Task3 : Title of the first Course

        String firstCourseTitle = js.getString("courses[0].title");
        System.out.println(firstCourseTitle);

        // Task 4 : Print all course title with their respective prices

        for (int i = 0; i < totalCourseCount; i++) {
            String title = js.get("courses[" + i + "].title");
            System.out.println("title : " + title);

            int price = js.get("courses[" + i + "].price");
            System.out.println("price : " + price);

        }

        // Task 5 : Print number of copies sold by RPA
        String expectedTitle = "Cypress";
        for (int i = 0; i < totalCourseCount; i++) {
            String title = js.get("courses[" + i + "].title");
            if (title.equals(expectedTitle)) {
                String expectedTitlePrice = js.get("courses[" + i + "].price").toString();
                System.out.println("expectedTitlePrice : " + expectedTitlePrice);

                String expectedTitleCopies = js.get("courses[" + i + "].copies").toString();
                System.out.println("expectedTitleCopies : " + expectedTitleCopies);
                break;
            }
        }

        // Task 6 : Verify if Sum of all Course prices matches with Purchase Amount
        int totalPrice = 0;
        for (int i = 0; i <totalCourseCount; i++) {
            int price = js.get("courses[" + i + "].price");
            int copies = js.get("courses[" + i + "].copies");
            totalPrice = totalPrice + (price * copies);
            System.out.println("totalPrice :" + totalPrice);
        }

        Assert.assertEquals(purchaseAmount, totalPrice);



    }
}
