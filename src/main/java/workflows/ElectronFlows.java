package workflows;

import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;
import utilities.Functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElectronFlows extends CommonOps {

    @Step("Business Flow: Add New Task to the List")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoListMain.getTxt_createTask(), taskName);
        UIActions.insertKey(todoListMain.getTxt_createTask(), Keys.RETURN);
    }

    @Step("Business Flow: Add New Task with Color Tag to the List")
    public static void addNewTask(String taskName, String colorTag) {
        UIActions.updateText(todoListMain.getTxt_createTask(), taskName);
        UIActions.click(todoListMain.getBtn_arrowDown());
        UIActions.click(todoListMain.getList_colorsMenu().get(Integer.parseInt(Functions.todoListTagColors(colorTag))));
        UIActions.insertKey(todoListMain.getTxt_createTask(), Keys.RETURN);
        UIActions.click(todoListMain.getBtn_noTag());
        UIActions.click(todoListMain.getBtn_arrowDown());
    }

    @Step("Business Flow: Delete Task from List")
    public static void deleteTask(String taskName) {
        for (int i = 0; i < getNumberOfTasks(); i++) {
            if (todoListMain.getList_tasks().get(i).getText().toUpperCase().contains(taskName.toUpperCase()))
                UIActions.mouseHover(todoListMain.getList_tasks().get(i).findElement(By.className("destroy_19w1q")));
        }
    }

    @Step("Business Flow: Count and Return Number of Tasks in List")
    public static int getNumberOfTasks() {
        return todoListMain.getList_tasks().size();
    }

    @Step("Business Flow: Count and Return Number of Tasks in List with specific color tag")
    public static int getNumberOfTasksByColorTag(String color) {
        List<WebElement> list = new ArrayList<>();
        for (WebElement taskColor : todoListMain.getList_tasksColorTag()){
            if (taskColor.getAttribute("style").equalsIgnoreCase(Functions.todoListTagColorsStyle(color)))
                list.add(taskColor);
        }
        return list.size();
    }

    @Step("Business Flow: Count and Return Number of Tasks from DB by Status sorting")
    public static int getNumberOfTasksFromDB_ByStatusSorting(String status) {
        return DBActions.getCredentials("SELECT Status FROM Tasks WHERE Status='"+status+"'").size();
    }

    @Step("Clear Tasks from List")
    public static void emptyList() {
        for (int i = 0; i < getNumberOfTasks(); i++) {
            UIActions.mouseHover(todoListMain.getBtn_X());
        }
    }

    @Step("Clear Tag")
    public static void chooseNoTagAndCloseTagMenu() {
        if (!todoListMain.getBtnsWraper_createTask().findElement(By.xpath(".//span")).getAttribute("class").equalsIgnoreCase("tag_21fhY hasNoTag_3ftX1")) {
            UIActions.click(todoListMain.getBtn_noTag());
            UIActions.click(todoListMain.getBtn_arrowDown());
        }
    }
}

