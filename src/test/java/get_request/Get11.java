package get_request;

import org.junit.Test;

public class Get11 {

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
        "Pres. Amarnath Dhawan","Sujata Chaturvedi","Navin Panicker" are among the users
    And
        The female users are less than or equals to male users
 */

    @Test
    public void get11() {


    }
}
