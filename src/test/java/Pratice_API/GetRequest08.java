package Pratice_API;

import base_url.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest08 extends GMIBankBaseUrl {
    /*
          http://www.gmibank.com/api/tp-customers/43703

          "firstName": "Alda",
          "lastName": "Monahan",
          "middleInitial": "Nichelle Hermann Kohler",
          "email": "com.github.javafaker.Name@7c011174@gmail.com",
          "mobilePhoneNumber": "909-162-8114",
          "city": "St Louis",
          "ssn": "108-53-6655"

          1) MATCHERS CLASS
          2) JSON PATH
          3) De-Serialization
    */

    @Test
    public void test08() {
        //set the url
        spec01.pathParams("first","tp-customers","second",43703);

        //set the expected
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("firstName","Alda");
        expectedData.put("lastName","Monahan");
        expectedData.put("middleInitial","Nichelle Hermann Kohler");
        expectedData.put("email","com.github.javafaker.Name@7c011174@gmail.com");
        expectedData.put("mobilePhoneNumber","909-162-8114");
        expectedData.put("city","St Louis");
        expectedData.put("ssn","108-53-6655");

        System.out.println(expectedData);

        //request ve response oluştur
        Response response = given().spec(spec01).headers("Authorization", "Bearer " + generateToken()).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertions
        //1) MATCHERS CLASS
        response.then().assertThat().body("firstName", equalTo("Alda")
                , "lastName", equalTo("Monahan")
                ,"middleInitial", equalTo("Nichelle Hermann Kohler")
                , "email", equalTo("com.github.javafaker.Name@7c011174@gmail.com")
                , "mobilePhoneNumber", equalTo("909-162-8114")
                , "city", equalTo("St Louis")
                , "ssn", equalTo("108-53-6655"));



        //2) JSON PATH
        //3) De-Serialization


    }
}
