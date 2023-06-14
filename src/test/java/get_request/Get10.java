package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Get10 extends GoRestBaseUrl {

         /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
            {
        "meta": null,
        "data": {
            "id": 2986,
            "name": "Prof. Bala Pilla",
            "email": "pilla_prof_bala@zemlak.io",=>burası inner class
            "gender": "female",
            "status": "active"
              }
         }
     */

    @Test
    public void get10() {

        //set the url
        spec.pathParams("first", "users", "second", "2986");

        //set the expected data
        //önce inner classı Map'e atamakla başlayacağız
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 2986);
        dataMap.put("name", "Prof. Bala Pilla");
        dataMap.put("email", "pilla_prof_bala@zemlak.io");
        dataMap.put("gender", "female");
        dataMap.put("status", "active");

        //outer class

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("meta", null);
        expectedDataMap.put("data", dataMap);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertions



    }
}
