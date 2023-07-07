package Pratice_API;

import base_url.GMIBankBaseUrl;
import org.junit.Test;

public class GetRequest09 extends GMIBankBaseUrl {
    /*
    http://www.gmibank.com/api/tp-customers/110452
     */

    @Test
    public void test09() {
        spec01.pathParams("first", "tp-customers", "second", 110452);






    }
}
