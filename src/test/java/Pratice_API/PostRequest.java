package Pratice_API;

import base_url.GMIBankBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.GMIBankCountryPostPojo;

import static io.restassured.RestAssured.given;

public class PostRequest extends GMIBankBaseUrl {

   // https://www.gmibank.com/api/tp-countries adresine yeni bir ülke ekleyiniz.

    @Test
    public void test10() {
    spec01.pathParam("first", "tp-countries");

        GMIBankCountryPostPojo GMIBankCountryPostPojo = new GMIBankCountryPostPojo("Batch81");
        System.out.println("countryPost = " + GMIBankCountryPostPojo);

        Response response = given()
                .headers("Authorization", "Bearer " + generateToken(), "Content-Type", ContentType.JSON)
                .spec(spec01).when().body(GMIBankCountryPostPojo)
                .post("/{first}");

        response.prettyPrint();

        GMIBankCountryPostPojo actualData = response.as(GMIBankCountryPostPojo.class);
        System.out.println("actualData = " + actualData);

        // Do ASSERTION
        Assert.assertEquals(GMIBankCountryPostPojo.getName(), actualData.getName());
    }
}
