package get_request;

import base_url.RestfulBaseUrl;
import org.junit.Test;

public class Get09 extends RestfulBaseUrl {
    
    /*
      Given
          https://restful-booker.herokuapp.com/booking/91
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
          "firstname": "Sally",
          "lastname": "Brown",
          "totalprice": 111,
          "depositpaid": true,
          "bookingdates": {
              "checkin": "2013-02-23",
              "checkout": "2014-10-23"
          },
          "additionalneeds": "Breakfast"
          }
   */

    @Test
    public void get09() {

    }
}
