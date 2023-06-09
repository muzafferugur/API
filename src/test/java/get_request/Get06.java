package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void get06() {
        //Set the url
        spec.pathParams("first", "booking", "second", 22);

        //set the expected data

        //send request and get the response(talep gönder ve cevap al)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion(doğrulama)
        //1.Yol
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

        //2.yol : Jsonpath class'ının kullanımı
        JsonPath json = response.jsonPath();
        assertEquals("Josh", json.getString("firstname"));
        assertEquals("Allen", json.getString("lastname"));
        assertEquals(111, json.getInt("totalprice"));
        assertTrue(json.getBoolean("depositpaid"));
        assertEquals("2018-01-01", json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01", json.getString("bookingdates.checkout"));
        assertEquals("midnight snack", json.getString("additionalneeds"));

        //3. Yol : Soft Assertion

        //softAssert class 3 adımda kullanılır

        //Obje oluşturma
        SoftAssert softAssert = new SoftAssert();

        // ii) Do Assertion (doğrulama yapma)
        softAssert.assertEquals(json.getString("firstname"), "Josh", "First Name Hatali");
        softAssert.assertEquals(json.getString("lastname"), "Allen", "Last Name Hatali");
        softAssert.assertEquals(json.getInt("totalprice"), 111, "Total Price Hatali");
        softAssert.assertEquals(json.getBoolean("depositpaid"), true, "Depositpaid Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"), "2018-01-01", "Check In Tarihi Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkout"), "2019-01-01", "Check out Tarihi Hatali");
        softAssert.assertEquals(json.getString("additionalneeds"), "midnight snack", "Additionalneeds Hatali");
        softAssert.assertAll();

        /**
       "softAssert.assertAll()" ifadesi, daha önce yapılan tüm doğrulama adımlarının sonuçlarını değerlendirir ve
       toplu olarak bir rapor üretir. Bu yöntem, tüm doğrulama adımlarının başarılı olup olmadığını kontrol eder.
       Eğer herhangi bir doğrulama adımı başarısız olduysa, testin başarısız olarak işaretlenmesini sağlar.

       Bunun avantajı, testin tüm doğrulama adımlarını tamamlamasına rağmen hataların olması durumunda,
       hataların tespit edilmesini ve raporlanmasını sağlamasıdır. Böylece, testin tamamının çalışmasını
       sürdürebilir ve tüm hataları belirleyebilirsiniz.

       API testlerinde "softAssert.assertAll()" kullanarak tüm doğrulama adımlarını kontrol etmek,
       hataları daha iyi tespit etmek ve test sonuçlarını daha ayrıntılı bir şekilde analiz etmek için önemlidir.
         */

    }
}
