package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FooterPage {

    @FindBy(xpath="//ul[@class='networks']/li")
    private List<WebElement> list_socialLinks;


    /*
    ##############################################################################
    Methods Names: Getter
    Method Description: This Method return List of WebElement of this Page Class.
    Method Parameters: void
    Method Return Type: List of WebElement
    ##############################################################################
     */

    public List<WebElement> getList_socialLinks(){
        return list_socialLinks;
    }

}
