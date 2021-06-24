package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HeaderApparelMenuPage {

    @FindBy(xpath="//a[@href='/shoes']")
    private WebElement link_shoes;

    @FindBy(xpath="//a[@href='/clothing']")
    private WebElement link_clothing;

    @FindBy(xpath="//a[@href='/accessories']")
    private WebElement link_accessories;


    /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getLink_shoes(){
        return link_shoes;
    }

    public WebElement getLink_clothing(){
        return link_clothing;
    }

    public WebElement getLink_accessories(){
        return link_accessories;
    }
}
