package get_requests;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class Get16 extends DummyRestApiBaseUrl {
     /*
          URL: https://dummy.restapiexample.com/api/v1/employees
          HTTP Request Method: GET Request
          Test Case: Type by using Gherkin Language
          Assert:  i) Status code is 200
                  ii) There are 24 employees
                 iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                  iv) The greatest age is 66
                   v) The name of the lowest age is "Tatyana Fitzpatrick"
                  vi) Total salary of all employees is 6,644,770
   */
    /*
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        user sends GET request
    Then
        i) Status code is 200
    And
        ii) There are 24 employees
    And
        iii) "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        iv) The greatest age is 66
    And
         v) The name of the lowest age is "Tatyana Fitzpatrick"
    And
        vi) Total salary of all employees is 6,644,770
     */

    @Test
    public void get16() {
      //set the url
      spec.pathParam("first","employees");

      //set the expected data

     Response response=given().spec(spec).when().get("/{first}");
     response.prettyPrint();

     //hamcrest matchers
        response.then().assertThat().body("data.id",hasSize(24));



    }
}
