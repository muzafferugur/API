package get_requests;

import base_url.RestfulBaseUrl;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

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


    }
}
