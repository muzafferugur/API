package Pratice_API;

import base_url.GMIBankBaseUrl;
import org.junit.Test;
import pojos.GMIBankCountryPojo;
import pojos.GMIBankCustomerPojo;
import pojos.GMIBankUserPojo;

public class GetRequest09 extends GMIBankBaseUrl {
    /*
    http://www.gmibank.com/api/tp-customers/110452
     */

    @Test
    public void test09() {
        spec01.pathParams("first", "tp-customers", "second", 110452);

    //Expected data
        /*
        {
    "id": 110452,
    "firstName": "Jasmine",
    "lastName": "Stehr",
    "middleInitial": "V",
    "email": "marni.zboncak@yahoo.com",
    "mobilePhoneNumber": "463-609-2097",
    "phoneNumber": "1-112-497-0270",
    "zipCode": "16525",
    "address": "14387 Al Ridge5343 Bert Burgs",
    "city": "Waltermouth",
    "ssn": "761-59-2911",
    "createDate": "2021-11-28T21:00:00Z",
    "zelleEnrolled": false,
    "country": {
        "id": 3,
        "name": "USA",
        "states": null
    },
    "state": "California",
    "user": {
        "id": 110016,
        "login": "leopoldo.reinger",
        "firstName": "Jasmine",
        "lastName": "Stehr",
        "email": "marni.zboncak@yahoo.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null
    },
    "accounts": []
}
         */

        GMIBankUserPojo GMIBankUserPojo = new GMIBankUserPojo(110016, "leopoldo.reinger", "Jasmine", "Stehr",
                "marni.zboncak@yahoo.com", true, "en", null, null);

        GMIBankCountryPojo GMIBankCountryPojo = new GMIBankCountryPojo(3, "USA", null);

        GMIBankCustomerPojo expectedData = new GMIBankCustomerPojo(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com"
                , "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs", "Waltermouth"
                , "761-59-2911", "2021-11-28T21:00:00Z", false, GMIBankCountryPojo, "California", GMIBankUserPojo);

        System.out.println("expectedData = " + expectedData);






    }
}
