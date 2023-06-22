package post_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.RestfulTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02 extends RestfulBaseUrl {

    /*
   Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2021-09-09",
                "checkout": "2021-09-21"
             }
          }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like
       {
    "bookingid": 168,
    "booking": {
        "firstname": "John",
        "lastname": "Doe",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2021-09-09",
            "checkout": "2021-09-21"
        }
    }
}
    */

    @Test
    public void post02() {

        //set the url
        spec.pathParam("first", "booking");

        //set the expected data(payload)
        RestfulTestData obj = new RestfulTestData();
        Map<String, String> bookingdatesMap = obj.bookingdatesMethod("2021-09-09", "2021-09-21");
        Map<String, Object> expectedData = obj.expectedDataMethod("John", "Doe", 11111, true, bookingdatesMap);

        //send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //do assertion
        Map<String, Object> actualData=response.as(HashMap.class);//De-Serialization
        System.out.println(actualData);








    }
}
