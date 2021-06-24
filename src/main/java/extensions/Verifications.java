package extensions;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Assert Text")
    public static void assertText(String actual, String expected){
        assertEquals(actual,expected);
    }

    @Step("Assert Number")
    public static void assertNumber(int actual, int expected){
        assertEquals(actual,expected);
    }

    @Step("Assert Text In Element")
    public static void assertTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(),expected);
    }

    @Step("Assert Text In Attribute")
    public static void assertTextInElementAttribute(WebElement elem, String attribute, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getAttribute(attribute),expected);
    }

    @Step("Assert Text In Element")
    public static void assertTextInElement(MobileElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(),expected);
    }

    @Step("Assert Condition")
    public static void assertCondition(Boolean isTrue){
        assertTrue(isTrue);
    }

    @Step("Assert Number Of Elements")
    public static void assertNumberOfElementsInList(List<WebElement> list, int expected){
        if (!list.isEmpty()){
            wait.until(ExpectedConditions.visibilityOfAllElements(list));
            assertEquals(list.size(),expected);
        }
        else
            assertEquals(0,expected);
    }

    @Step("Assert Visibility Of Elements (Soft Assertion)")
    public static void softAssertVisibilityOfElements(List<WebElement> list){
        for(int i=0; i< list.size(); i++){
            softAssert.assertTrue(list.get(i).isDisplayed(),list.get(i).getText()+" not Displayed");
        }
        softAssert.assertAll();
    }

    @Step("Assert Element Visually")
    public static void assertElementVisually(String expectedImageName){
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed findFailed) {
            fail("Error Comparing Image Files: "+findFailed);
        }
    }

    @Step("Assert Single and Only Existence Of Specified Record in List")
    public static void assertSingleAndOnlyExistenceOfSpecifiedRecordInList(List<WebElement> list, String record){
        if (list.get(0).getText().equalsIgnoreCase(record))
            assertEquals(list.size(),1);
        else
            fail("Specified Record does not Exist in List");
    }

    @Step("Assert List is Empty")
    public static void assertListIsEmpty(List<WebElement> list){
        assertTrue(list.isEmpty());
    }

    @Step("Assert Non Existence of Specified Record in List")
    public static void assertNonExistenceOfSpecifiedRecordInList(List<WebElement> list, String record) {
        boolean recordNotPresent = true;
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).getText().equalsIgnoreCase(record))
                recordNotPresent=false;
        }
        assertTrue(recordNotPresent);
    }

}
