package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdidasRunningShoesPage {

    @FindBy(id="add-to-cart-button-25")
    private WebElement btn_addToCart;

    @FindBy(id="product_attribute_9")
    private WebElement select_shoeSize;



    /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getBtn_addToCart(){
        return btn_addToCart;
    }

    public WebElement getSelect_shoeSize(){
        return select_shoeSize;
    }
}
