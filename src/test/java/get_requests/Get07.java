package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonplaceholderBaseUrl {
    /*
      Given
            https://jsonplaceholder.typicode.com/todos
      When
             I send GET Request to the URL == > URL'e Get Request gonderin
      Then
    1)Status code is 200 == > Status kodu 200 olmali
    2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
              Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
    3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
              Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
    4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
              Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
              basliginin "delectus aut autem" icerdigini dogrulayin
   */

    @Test
    public void get07() {
        //set the url
        spec.pathParams("first", "todos");

        //set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint()

        //Do Assertion

        // 1) Status code is 200 == > Status kodu 200 olmali
        response.then().assertThat().statusCode(200);
        //assertEquals(200,response.getStatusCode());

        //2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
        JsonPath json = response.jsonPath();
        List<Integer> idler = json.getList("findAll{it.id>190}.id"); //Groovy Language=Java Temelli programlama dili
        System.out.println("id si 190 dan buyuk olanlar :" + idler);

        // Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
        assertEquals("Id 190 dan buyuk olanlar eslesmedi", 10, idler.size());

        // 3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
        List<Integer> userIdler = json.getList("findAll{it.id<5}.userId");
        System.out.println("id si 5 den kucuk olan userIdler :" + userIdler);

        // Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
        assertEquals("Id'si 5 ten kucuk olan userıdler 4 tane değil", 4, userIdler.size());

        // 4) Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
        List<String> titles = json.getList("findAll{it.id<5}.title");
        System.out.println("Id'si 5'ten kucuk olan titlelar : " + titles);

        // Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
        // basliginin "delectus aut autem" icerdigini dogrulayin.
        assertTrue("Id'si 5'ten kucuk olan Title'lardan herhangi bir tanesi delectus aut autem icermemektedir.",
                titles.contains("delectus aut autem"));

        assertTrue("Id'si 5'ten kucuk olan Title'lardan herhangi bir tanesi delectus aut autem icermemektedir.",
                titles.stream().anyMatch(t -> t.equals("delectus aut autem")));

    }
}
