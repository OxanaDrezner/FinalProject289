package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage {

    @FindBy(className="ajax-products-busy")
    private WebElement productContainerAjax;



    /*
    #########################################################################
    Methods Names: Getter
    Method Description: This Method return WebElement of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getProductContainerAjax(){
        return productContainerAjax;
    }

}
