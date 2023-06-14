package get_request;

import java.util.HashMap;
import java.util.Map;

public class GoRestData {

    public Map<String, String> dataKeyMapMet(String name, String email, String gender, String status) {
        Map<String, String> dataKeyMap = new HashMap<>();
        dataKeyMap.put("name", name);
        dataKeyMap.put("email", email);
        dataKeyMap.put("gender", gender);
        dataKeyMap.put("status", status);

        return dataKeyMap;
    }

    public Map<String, Object> expectedDataMethod(Object meta, Map<String, String> data) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("meta", meta);
        expectedData.put("data", data);

        return expectedData;
    }
}