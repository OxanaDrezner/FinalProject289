package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoesPage {

    @FindBy(id="products-orderby")
    private WebElement select_orderBy;

    @FindBy(xpath="//div[@class='item-box']")
    private List<WebElement> list_products;



   /*
    #########################################################################
    Methods Names: Getter
    Method Description: This Method return WebElement of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getSelect_orderBy(){
        return select_orderBy;
    }


    /*
    ##############################################################################
    Methods Names: Getter
    Method Description: This Method return List of WebElement of this Page Class.
    Method Parameters: void
    Method Return Type: List of WebElement
    ##############################################################################
     */

    public List<WebElement> getList_products(){
        return list_products;
    }

}
