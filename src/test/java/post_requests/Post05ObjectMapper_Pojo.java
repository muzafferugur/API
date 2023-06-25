package post_requests;

import base_url.JsonplaceholderBaseUrl;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

public class Post05ObjectMapper_Pojo extends JsonplaceholderBaseUrl {

    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post05ObjectMapper() {
        //set the url
        spec.pathParam("first","todos");

        //set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);







    }
}
