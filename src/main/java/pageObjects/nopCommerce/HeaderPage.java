package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage {

    @FindBy(className="ico-register")
    private WebElement link_register;

    @FindBy(className="ico-wishlist")
    private WebElement link_wishlist;

    @FindBy(className="ico-cart")
    private WebElement link_cart;

    @FindBy(id="small-searchterms")
    private WebElement txt_search;

    @FindBy(xpath="//button[@class='button-1 search-box-button']")
    private WebElement btn_search;

    @FindBy(xpath="//a[@href='/computers']")
    private WebElement link_computers;

    @FindBy(xpath="//a[@href='/electronics']")
    private WebElement link_electronics;

    @FindBy(xpath="//a[@href='/apparel']")
    private WebElement link_apparel;

    @FindBy(xpath="//a[@href='/digital-downloads']")
    private WebElement link_downloads;

    @FindBy(xpath="//a[@href='/books']")
    private WebElement link_books;

    @FindBy(xpath="//a[@href='/jewelry']")
    private WebElement link_jewelry;

    @FindBy(xpath="//a[@href='/gift-cards']")
    private WebElement link_cards;



    /*
    #########################################################################
    Methods Names: Getters
    Method Description: This Methods return WebElements of this Page Class.
    Method Parameters: void
    Method Return Type: WebElement
    #########################################################################
     */

    public WebElement getLink_register(){
        return link_register;
    }

    public WebElement getLink_wishlist(){
        return link_wishlist;
    }

    public WebElement getLink_cart(){
        return link_cart;
    }

    public WebElement getTxt_search(){
        return txt_search;
    }

    public WebElement getBtn_search(){
        return btn_search;
    }

    public WebElement getLink_computers(){
        return link_computers;
    }

    public WebElement getLink_electronics(){
        return link_electronics;
    }

    public WebElement getLink_apparel(){
        return link_apparel;
    }

    public WebElement getLink_downloads(){
        return link_downloads;
    }

    public WebElement getLink_books(){
        return link_books;
    }

    public WebElement getLink_jewelry(){
        return link_jewelry;
    }

    public WebElement getLink_cards(){
        return link_cards;
    }
}
