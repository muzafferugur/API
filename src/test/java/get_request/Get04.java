package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonplaceholderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
      When
            I send a GET Request to the URL
      And
          Accept type is "application/json"
      Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          There should be 200 todos=>200 tane todos bul diyor=>id unique olduğundan id den yürüyebiliriz
      And
          "quis eius est sint explicabo" should be one of the todos title,=>en az bir tane title  "quis eius est sint explicabo" içermelidir
      And
          "completed" is false
      And
         2, 7 ande 9 should be among the userId's
     */

    /**
     * * Matchers Class kullanarak doğrulama
     *   http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
     *
     *   Matchers.equalto(): Key-Value şeklinde girilen datanın, eşit olduğunu doğrulamak için kullanılır.
     *   Matchers.hasSize(): Datanın size'ını doğrulamak için kullanılır.
     *   Matchers.hasItem(): Girilen tek bir data'yı doğrulamak için kullanılır.
     *   Matchers.hasItems(): Girilen birden fazla datayı doğrulamak için kullanılır.
     */

    @Test
    public void test01() {

        //Set the Url
        spec.pathParam("first", "todos");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().accept(ContentType.JSON).when()
                .get("/{first}");
        response.prettyPrint();

        //Do Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", hasSize(200), "title", hasItem("quis eius est sint explicabo"),
                        "userId", hasItems(2, 7, 9));

    }
}
