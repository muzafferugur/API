package get_request;

import base_url.RestfulBaseUrl;
import org.junit.Test;

public class Get05 extends RestfulBaseUrl {

     /*
     Given
        https://restful-booker.herokuapp.com/booking
    When
        User send a GET Request to the url
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
      */

    @Test
    public void test01() {
        //Set the Url
        spec.pathParam("first","booking");

        //Set the Expected data
        //Send the request and get the response


    }
}
