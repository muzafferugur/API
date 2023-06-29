package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {
    /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
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
    public void get15() {
        //set the url
        spec.pathParams("first", "booking", "second", 22);

        //set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Josh", "Allen", 111, true, bookingDatesPojo, "midnight snack");

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);

        //hard assertion
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

        //soft assertion
        //1.adım: SoftAssert objesi oluştur
        SoftAssert softAssert = new SoftAssert();

        //2.adım: Assertion yap(soft assertionda önce actualdata sonra expecteddata)
        softAssert.assertEquals(actualData.getFirstname(),expectedData.getFirstname(),"First name uyusmadi");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"Last name uyusmadi");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"Total price uyusmadi");
        softAssert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid(),"Deposit paid uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),expectedData.getBookingdates().getCheckin(),"Checkin date uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(),expectedData.getBookingdates().getCheckout(),"Checkout date uyusmadi");
        softAssert.assertEquals(actualData.getAdditionalneeds(),expectedData.getAdditionalneeds(),"Additional needs uyusmadi");

        //3.adım:assertAll() methodunu kullan
        softAssert.assertAll();

    }
}
