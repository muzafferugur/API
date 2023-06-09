package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

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
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "midnight snack"
}

      */

    @Test
    public void test01() {
        //Set the url
        spec.pathParams("first", "booking", "second", 22);

        //set the expected data

        //send request and get the response(talep gönder ve cevap al)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion(doğrulama)
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Josh"),
                        "lastname", equalTo("Allen"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("midnight snack"));

    }
}
