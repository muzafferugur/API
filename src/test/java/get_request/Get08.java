package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get08 extends JsonplaceholderBaseUrl {
    // De-Serialization: Json datayı Java objesine çevirme
    // Serialization: Java objesini Json formatına çevirme.=>jsonPath bunu bizim için yapıyor
    // De-Serialization: Iki türlü yapacağız.
    // Gson: Google tarafından üretilmiştir.
    // Object Mapper: Daha popüler...

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get08() {
        //set the url
        spec.pathParams("first","todos","second",2);

        //set the expected data=>payload
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println(expectedData);


        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertions









    }
}
