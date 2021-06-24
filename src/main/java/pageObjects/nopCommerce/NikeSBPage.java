package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NikeSBPage {

    @FindBy(id="add-to-cart-button-26")
    private WebElement btn_addToCart;


    /*
    #########################################################################
    Methods Names: Getter
    Method Description: This Method return WebElement of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getBtn_addToCart(){
        return btn_addToCart;
    }
}
