package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get06 extends RestfulBaseUrl {
    /*
     Given
        https://restful-booker.herokuapp.com/booking/22
    When
        User send a GET Request to the url
    Then
       HTTP Status code should be 200
    And
       Response Content Type is "application/json"
    And
        Response body should be like;

        {
    "firstname": "Jane",
    "lastname": "Doe",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Extra pillows please"
}

      */

    @Test
    public void test01() {
        //Set the url
        spec.pathParams("first","booking","second",22);
        //set the expected data
        //send request and get the response(talep gönder ve cevap al)
        Response response =given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //do assertion(doğrulama)
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body()

    }
}
