package get_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;//RestAssured ın tüm fonksiyonlarını kullanabilmek için * koyduk
import static org.hamcrest.Matchers.*;//=>Matchers ın tüm fonksiyonlarını kullanabilmek için * koyduk

/**
 * * Rest Assured: REST API'lerini test etmek ve doğrulamak için kullanılan
 *                 Open Source (Açık Kaynak) bir Java kütüphanesidir.
 *  Matchers.equalto(): Key-Value şeklinde girilen datanın, eşit olduğunu doğrulamak için kullanılır.
 */
public class Get03 extends JsonplaceholderBaseUrl {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */

    @Test
    public void get03(){

        // Set The URL

        spec.pathParams("first","todos","second",23);
        //spec.=>bizim baseUrl'imiz

        //=> "todos"->ilk parametre,  23->ikinci parametre =>bunları eklemek için pathParams() kuullanırız.tek parametre için pathParam()

        // Expected Data(bizden istenirse Put,Patch,Post kullanarak yaparız)

        // Send the request and Get Response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        //1.Yol (Hard Assert)=>farklı bodyler kullanıyorsak=>ilk hatada kod çalışmayı durdurur ve diğerlerini çalıştırmaz
        response.then().assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

        //2.Yol (Soft Assert)=>aynı body içerisinde testimizi yapıyoruz.=>tüm testler yapılır
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId",equalTo(2));

        /*
        {
    "userId": 2,
    "id": 23,
    "title": "et itaque necessitatibus maxime molestiae qui quas velit",
    "completed": false
}
         */





    }


}