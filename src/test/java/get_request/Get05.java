package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get05 extends RestfulBaseUrl {

     /*
     Given
        https://restful-booker.herokuapp.com/booking
    When
        User send a GET Request to the url
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Jim" and lastname is "Jackson"
      */

    @Test
    public void test01() {
        //https://restful-booker.herokuapp.com/booking/?firstname=Jim&lastname=Jackson=>bunu postman de manuel olarak yaptık bu url i oluşturmaya çalışıyoruz buradan
        //?firstname=Jim&lastname=Jackson=>soru işaretinden sonraki kısımda sorgulama başlıyor->query
        //Set the Url
        spec.pathParam("first", "booking").queryParams("firstname", "Jim", "lastname", "Jackson");
        //=>queryParams("   ")->sorgu parametreleri eklememiz için kullanırız

        //Set the Expected data
        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do Assertion
        assertEquals(200, response.getStatusCode());//daha sade daha temiz
        assertTrue(response.asString().contains("bookingid"));

        //response.then().assertThat().statusCode(200)..artık bunu yapmıyoruz

    }
}
