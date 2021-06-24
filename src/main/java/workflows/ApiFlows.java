package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Extract Student Data")
    public static String getStudentData(String jPath){
        return ApiActions.extractFromJSON(ApiActions.get("/student/list"),jPath);
    }

    @Step("Business Flow: Create New Student")
    public static void postNewStudent(String firstName, String lastName, String email, String programme, String course0,String course1,String course2){
        params.put("firstName",firstName);
        params.put("lastName",lastName);
        params.put("email",email);
        params.put("programme",programme);
        List<String> courses = new ArrayList<>(Arrays.asList(course0,course1,course2));
        courses.removeAll(Collections.singleton("null"));
        if (!courses.isEmpty())
            params.put("courses",courses);

        ApiActions.post(params,"/student");
    }

    @Step("Business Flow: Update Existing Student")
    public static void updateStudent(String id,String firstName, String lastName, String email, String programme, String course0,String course1,String course2){
        params.put("firstName",firstName);
        params.put("lastName",lastName);
        params.put("email",email);
        params.put("programme",programme);
        List<String> courses = new ArrayList<>(Arrays.asList(course0,course1,course2));
        courses.removeAll(Collections.singleton("null"));
        if (!courses.isEmpty())
            params.put("courses",courses);

        ApiActions.put(params,"/student/"+id);
    }

    @Step("Business Flow: Delete Existing Student")
    public static void deleteStudent(String id){
        ApiActions.delete("/student/"+id);
    }

    @Step("Business Flow: Get Status Code of the Current Response ")
    public static int getResponseStatusCode(Response response){
        return response.getStatusCode();
    }
}
