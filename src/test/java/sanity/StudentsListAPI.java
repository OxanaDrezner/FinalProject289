package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;


@Listeners(utilities.Listeners.class)
public class StudentsListAPI extends CommonOps {

    @Test(description = "Test01 - Verify Student Data")
    @Description("This test Verifies Student Data is Correct")
    public void Test01_VerifyStudentData(){
        Verifications.assertText(ApiFlows.getStudentData("[2].courses[2]"),"Software Development");
    }

    @Test(description = "Test02 - Add Student And Verify Addition")
    @Description("This test Adds New Student and Verifies it's Addition")
    public void Test02_AddStudentAndVerifyAddition(){
        ApiFlows.postNewStudent("Oxana","Drezner","foxana84@gmail.com","Software Automation","Java","Python","null");
        Verifications.assertText(ApiFlows.getStudentData("[100].firstName"),"Oxana");
    }

    @Test(description = "Test03 - Update Student And Verify")
    @Description("This test Updates Student and Verifies new Data is Updated")
    public void Test03_UpdateStudentAndVerify(){
        ApiFlows.updateStudent(ApiFlows.getStudentData("[100].id"),"Oxana","Drezner","foxana84@gmail.com","Software Automation","Java","null", "C#");
        Verifications.assertText(ApiFlows.getStudentData("[100].courses[1]"),"C#");
    }

    @Test(description = "Test04 - Delete Student And Verify Deletion")
    @Description("This test Deletes Student and Verifies Deletion")
    public void Test04_DeleteStudentAndVerifyDeletion(){
        ApiFlows.deleteStudent(ApiFlows.getStudentData("[100].id"));
        Verifications.assertNumber(ApiFlows.getResponseStatusCode(response), 204);
    }

}
