package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

public class ApiActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String resource){
        response = httpRequest.get(resource);
        return response;
    }

    @Step("Extract Value From JSON Format")
    public static String extractFromJSON(Response response,String path) {
        jp = response.jsonPath();
        if (jp.get(path)!= null)
            return jp.get(path).toString();
        else
            throw new RuntimeException("Given Path: "+path+", Does not Exist");
    }

    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        response.prettyPrint();
    }

    @Step("Update Data in Server")
    public static void put(JSONObject params, String resource){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        response.prettyPrint();
    }

    @Step("Delete Data from Server")
    public static void delete(String resource){
        response = httpRequest.delete(resource);
    }
}
