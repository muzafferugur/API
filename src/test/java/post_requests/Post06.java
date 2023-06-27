package post_requests;

import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;

import static io.restassured.RestAssured.given;

public class Post06 extends DummyRestApiBaseUrl {

    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body:
                     {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 4891
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */


    /*
    Given
        https://dummy.restapiexample.com/api/v1/create


    And {
    "employee_name": "Tom Hanks",
    "employee_salary": 111111,
    "employee_age": 23,
    "profile_image": "Perfect image",
    "id": 4891
    }

    When
     User send Post requests

    Then
     Status cose is 200

    And
    Response body should be like the following
    {
    "status": "success",
    "data": {
        "employee_name": "Tom Hanks",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image",
        "id": 6990
      },
    "message": "Successfully! Record has been added."
    }

     */

    @Test
    public void post06() {
        //set the url
        spec.pathParam("first", "create");

        //set the expected data
        DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo("Tom Hanks", 111111, 23, "Perfect image");
        System.out.println("expectedData = " + expectedData);

        //send the post request and get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //do assertion



    }
}
