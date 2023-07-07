package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class Get04b extends RestfulBaseUrl {
       /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "John" and lastname is "Smith"

     */

    @Test
    public void get04(){
//Set the Url
        spec.pathParam("first","booking").queryParams("firstname","John","lastname","Smith");

//Set The Expected Data

//Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

//Do Assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
