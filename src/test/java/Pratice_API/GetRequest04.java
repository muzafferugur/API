package Pratice_API;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {
    @Test
    public void test() {

        //token oluşturma ve authorized login
        //bütün müşteri bilgilerine bu şekilde ulaşabiliyoruz

        String url ="https://www.gmibank.com/api/tp-customers";
        String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRjaDgxIiwiYXV0aCI6IlJPTEVfQURNSU4iLCJleHAiOjE2ODkzNzEzNjF9.HMSRfnM7XDebs7_g77wO4RgZgw51MeHejMx64NWFr5SWDjwnQ73Qi8GHW-n-gV9ha3gECMXJEgmNGHAcELMWQA";

        Response response =given().headers("Authorization","Bearer "+token).when().get(url);
        response.prettyPrint();
    }
}
