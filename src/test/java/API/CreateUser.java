package API;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

public class CreateUser {
    @Test
    public void test_post(){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 27);
        map.put("username", "Misha");
        map.put("firstName", "Michael");
        map.put("lastName", "Malikov");
        map.put("email", "maliksandalik97@gmail.com");
        map.put("password", "12345678");
        map.put("phone", "+79991234565");
        map.put("userStatus", 1);

        System.out.println(map);

        JSONObject request = new JSONObject(map);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                header("accept","application/json").
                body(request.toJSONString()).
                when().
                post("https://petstore.swagger.io/v2/user").
                then().
                statusCode(200).
                log().all();
    }
}
