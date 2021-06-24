package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Click on Element with JSExecutor")
    public static void JSclick(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
    }

    @Step("Update Text in Element")
    public static void updateText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys value){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Select Element From DropDown")
    public static void selectFromDropDown(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("MouseHover 2 Elements")
    public static void mouseHover(WebElement elem1,WebElement elem2){
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("MouseHover 1 Element")
    public static void mouseHover(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.moveToElement(elem).click().build().perform();
    }

    @Step("Double Click an Element")
    public static void doubleClick(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        action.doubleClick(elem).build().perform();
    }
}
