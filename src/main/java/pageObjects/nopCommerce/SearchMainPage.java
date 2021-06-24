package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchMainPage {

    @FindBy(xpath="//div[@class='item-box']")
    private List<WebElement> list_products;

    @FindBy(className="product-title")
    private List<WebElement> list_productsTitles;



    /*
    ##############################################################################
    Methods Names: Getters
    Method Description: This Methods return Lists of WebElement of this Page Class.
    Method Parameters: void
    Method Return Type: List of WebElement
    ##############################################################################
     */

    public List<WebElement> getList_products(){
        return list_products;
    }

    public List<WebElement> getList_productsTitles(){
        return list_productsTitles;
    }
}
