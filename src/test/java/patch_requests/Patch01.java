package patch_requests;

import base_url.JsonplaceholderBaseUrl;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

public class Patch01 extends JsonplaceholderBaseUrl {
    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "title": "Wash the dishes"
           }
    When
       I send PATCH Request to the Url
    Then
      Status code is 200
      And response body is like   {
                   "userId": 10,
                   "title": "Wash the dishes",
                   "completed": true,
                   "id": 198
                   }
    */

    @Test
    public void patch01() {

        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod(null, "Wash the dishes", null);


    }
}
