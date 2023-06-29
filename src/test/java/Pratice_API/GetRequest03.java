package Pratice_API;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {

    /*
    //Matchers yöntemi ile(Matchers.equalTo)
    id'si 5 olanın datalarınının aşağıdaki gibi olduğunu test ediniz
    "https://reqres.in/api/users"
    {
        "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
    }

     */

    @Test
    public void name() {
        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);
        // (Hard Assert)
        response.then()
                .body("data[4].id",equalTo(5))
                .body("data[4].email",equalTo("charles.morris@reqres.in"))
                .body("data[4].first_name",equalTo("Charles"))
                .body("data[4].last_name",equalTo("Morris"));
    }
}
