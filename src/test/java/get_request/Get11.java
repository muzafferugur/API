package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get11 extends GoRestBaseUrl {

    /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        "Bhuvanesh Bhattacharya","Bhadran Asan","Surya Mehra" are among the users
    And
        The female users are less than or equals to male users


        C:\Users\muzaf\.jdks\openjdk-18.0.2.1\bin\java.exe -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.2\lib\idea_rt.jar=56875:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.2\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.2\plugins\junit\lib\junit5-rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2022.1.2\plugins\junit\lib\junit-rt.jar;C:\Users\muzaf\IdeaProjects\APINotes\target\test-classes;C:\Users\muzaf\IdeaProjects\APINotes\target\classes;C:\Users\muzaf\.m2\repository\io\rest-assured\rest-assured\5.3.0\rest-assured-5.3.0.jar;C:\Users\muzaf\.m2\repository\org\apache\groovy\groovy\4.0.6\groovy-4.0.6.jar;C:\Users\muzaf\.m2\repository\org\apache\groovy\groovy-xml\4.0.6\groovy-xml-4.0.6.jar;C:\Users\muzaf\.m2\repository\org\apache\httpcomponents\httpclient\4.5.13\httpclient-4.5.13.jar;C:\Users\muzaf\.m2\repository\org\apache\httpcomponents\httpcore\4.4.13\httpcore-4.4.13.jar;C:\Users\muzaf\.m2\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;C:\Users\muzaf\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\muzaf\.m2\repository\org\apache\httpcomponents\httpmime\4.5.13\httpmime-4.5.13.jar;C:\Users\muzaf\.m2\repository\org\hamcrest\hamcrest\2.1\hamcrest-2.1.jar;C:\Users\muzaf\.m2\repository\org\ccil\cowan\tagsoup\tagsoup\1.2.1\tagsoup-1.2.1.jar;C:\Users\muzaf\.m2\repository\io\rest-assured\json-path\5.3.0\json-path-5.3.0.jar;C:\Users\muzaf\.m2\repository\org\apache\groovy\groovy-json\4.0.6\groovy-json-4.0.6.jar;C:\Users\muzaf\.m2\repository\io\rest-assured\rest-assured-common\5.3.0\rest-assured-common-5.3.0.jar;C:\Users\muzaf\.m2\repository\io\rest-assured\xml-path\5.3.0\xml-path-5.3.0.jar;C:\Users\muzaf\.m2\repository\org\apache\commons\commons-lang3\3.11\commons-lang3-3.11.jar;C:\Users\muzaf\.m2\repository\org\json\json\20230227\json-20230227.jar;C:\Users\muzaf\.m2\repository\org\testng\testng\7.7.0\testng-7.7.0.jar;C:\Users\muzaf\.m2\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;C:\Users\muzaf\.m2\repository\com\beust\jcommander\1.82\jcommander-1.82.jar;C:\Users\muzaf\.m2\repository\org\webjars\jquery\3.6.1\jquery-3.6.1.jar;C:\Users\muzaf\.m2\repository\com\google\code\gson\gson\2.10.1\gson-2.10.1.jar;C:\Users\muzaf\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.15.0\jackson-databind-2.15.0.jar;C:\Users\muzaf\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.15.0\jackson-annotations-2.15.0.jar;C:\Users\muzaf\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.15.0\jackson-core-2.15.0.jar;C:\Users\muzaf\.m2\repository\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar;C:\Users\muzaf\.m2\repository\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar;C:\Users\muzaf\.m2\repository\junit\junit\4.13.2\junit-4.13.2.jar;C:\Users\muzaf\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar" com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 get_request.Get11,get11
{
    "meta": {
        "pagination": {
            "total": 2936,
            "pages": 294,
            "page": 1,
            "limit": 10,
            "links": {
                "previous": null,
                "current": "https://gorest.co.in/public/v1/users?page=1",
                "next": "https://gorest.co.in/public/v1/users?page=2"
            }
        }
    },
    "data": [
        {
            "id": 3061246,
            "name": "Bhuvanesh Bhattacharya",
            "email": "bhuvanesh_bhattacharya@haag.test",
            "gender": "male",
            "status": "active"
        },
        {
            "id": 3061245,
            "name": "Dakshayani Butt V",
            "email": "butt_dakshayani_v@aufderhar-mitchell.example",
            "gender": "male",
            "status": "inactive"
        },
        {
            "id": 3061243,
            "name": "Bhadran Asan",
            "email": "asan_bhadran@osinski.test",
            "gender": "male",
            "status": "inactive"
        },
        {
            "id": 3061242,
            "name": "Rajinder Malik",
            "email": "malik_rajinder@lind.example",
            "gender": "female",
            "status": "active"
        },
        {
            "id": 3061240,
            "name": "Amaranaath Kaniyar DO",
            "email": "kaniyar_amaranaath_do@stoltenberg.example",
            "gender": "female",
            "status": "active"
        },
        {
            "id": 3061239,
            "name": "Chandrakin Achari",
            "email": "achari_chandrakin@grady.test",
            "gender": "female",
            "status": "active"
        },
        {
            "id": 3061238,
            "name": "Aishani Chopra",
            "email": "aishani_chopra@stokes.example",
            "gender": "female",
            "status": "inactive"
        },
        {
            "id": 3061237,
            "name": "Chapal Naik",
            "email": "chapal_naik@price.example",
            "gender": "male",
            "status": "inactive"
        },
        {
            "id": 3061236,
            "name": "Surya Mehra",
            "email": "surya_mehra@weimann.test",
            "gender": "female",
            "status": "active"
        },
        {
            "id": 3061235,
            "name": "Baalagopaal Somayaji",
            "email": "baalagopaal_somayaji@roob.test",
            "gender": "female",
            "status": "inactive"
        }
    ]
}

    */

    @Test
    public void get11() {

        //Set the url
        spec.pathParam("first","users");

        //set the expected data

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //do assertions
        response.then().assertThat()
                .statusCode(200)
                .body("meta.pagination.limit",equalTo(10),
                        "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Bhuvanesh Bhattacharya","Bhadran Asan","Surya Mehra"));

    }
}
