package put_requests;

import base_url.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {
    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    /*
    Given
    https://dummy.restapiexample.com/api/v1/update/21
       {
         "employee_name": "Ali Can",
         "employee_salary": 111111,
         "employee_age": 23,
         "profile_image": "Perfect image"
       }

    When
    User send Put request

    Then
    i) Status code is 200

    And
    ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }

     */

    @Test
    public void put02() {

        spec.pathParams("first", "update", "second", 21);
        DummyRestApiDataPojo dummyRestApiDataPojo = new DummyRestApiDataPojo("Ali Can", 111111, 23, "Perfect image");
        DummyRestApiResponseBodyPojo expectedData = new DummyRestApiResponseBodyPojo("success", dummyRestApiDataPojo, "Successfully! Record has been updated.");
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(dummyRestApiDataPojo).put("/{first}/{second}");
        response.prettyPrint();

        DummyRestApiResponseBodyPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponseBodyPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());

        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.getMessage(), actualData.getMessage());

        assertEquals(dummyRestApiDataPojo.getEmployee_name(), actualData.getData().getEmployee_name());
        assertEquals(dummyRestApiDataPojo.getEmployee_age(), actualData.getData().getEmployee_age());
        assertEquals(dummyRestApiDataPojo.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(dummyRestApiDataPojo.getProfile_image(), actualData.getData().getProfile_image());




    }
}
