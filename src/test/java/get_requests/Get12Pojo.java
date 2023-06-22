package get_requests;

import base_url.RestfulBaseUrl;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

public class Get12Pojo extends RestfulBaseUrl {

    /*
     Given
         https://restful-booker.herokuapp.com/booking/18
     When
         I send GET Request to the URL
     Then
        Status code is 200
     And
        Response body is like:
   {
    "firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
    */

    @Test
    public void get12Pojo() {
        //set the url
        spec.pathParams("first","booking","second",18);

        //set the expected data
        //inner
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        System.out.println(bookingDatesPojo);

        //expected data
        BookingPojo bookingPojo=new BookingPojo("John","Smith",111,true,bookingDatesPojo,"Breakfast");
        System.out.println(bookingPojo);







    }
}
