package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class ToDoListElectron extends CommonOps {

    @Test(description = "Test01 - Add and Verify New Task")
    @Description("This test adds a new task and verifies it's addition")
    public void Test01_addAndVerifyNewTask(){
        ElectronFlows.addNewTask("Learn Java");
        Verifications.assertNumber(ElectronFlows.getNumberOfTasks(),1);
    }

    @Test(description = "Test02 - Add Task with color tag and Verify the color")
    @Description("This test adds a new task tagged by color and verifies the color shown is correct")
    public void Test02_addTaskWithColorTagAndVerifyTheColor(){
        ElectronFlows.addNewTask("Learn Java","Grey");
        Verifications.assertTextInElementAttribute(todoListMain.getList_tasksColorTag().get(0),"style","background: rgb(165, 165, 167);");
    }

    @Test(description = "Test03 - Add New Tasks, Delete 1 Task and Verify Deletion")
    @Description("This test adds some new tasks to the list, deletes one task and verifies it's deletion")
    public void Test03_addNewTasksDeleteOneTaskAndVerifyDeletion(){
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn Python");
        ElectronFlows.deleteTask("Learn C#");
        Verifications.assertNonExistenceOfSpecifiedRecordInList(todoListMain.getList_tasksLabel(), "Learn C#");
    }

    @Test(description = "Test04 - Add Tasks with color tag and Verify With DB Data")
    @Description("This test adds new tasks tagged by color and verifies the quantity of specific color comparing to DB Data")
    public void Test04_addTasksWithColorTagAndVerifyWithDBData(){
        ElectronFlows.addNewTask("Learn Java","Red");
        ElectronFlows.addNewTask("Learn Python","Red");
        ElectronFlows.addNewTask("Learn C#","Orange");
        ElectronFlows.addNewTask("Learn Ruby","Yellow");
        Verifications.assertNumber(ElectronFlows.getNumberOfTasksFromDB_ByStatusSorting("Critical"),ElectronFlows.getNumberOfTasksByColorTag("Red"));
    }

}
