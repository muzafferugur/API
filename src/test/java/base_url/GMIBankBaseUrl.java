package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utils.Authentication;

public class GMIBankBaseUrl extends Authentication {

    protected RequestSpecification spec01;

    @Before
    public void setUp(){
        spec01 = new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api/").build();
    }
}
