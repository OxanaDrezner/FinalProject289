package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.nopCommerce.*;


public class ManagePages extends Base {

    /*
    ######################################################################################
    Method Name: initNopCommerce
    Method Description: This Method Initializes elements and return Page Objects
                        of all Page Objects classes referred to NopCommerce Application.
    Method Parameters: void
    Method Return Type: void
    ######################################################################################
     */
    public static void initNopCommerce(){
        nopCommerceRegister = PageFactory.initElements(driver, RegisterPage.class);
        nopCommerceHeader = PageFactory.initElements(driver, HeaderPage.class);
        nopCommerceHeaderApparelMenu = PageFactory.initElements(driver, HeaderApparelMenuPage.class);
        nopCommerceShoes = PageFactory.initElements(driver, ShoesPage.class);
        nopCommerceAdidasRunningShoes = PageFactory.initElements(driver, AdidasRunningShoesPage.class);
        nopCommerceCartMain = PageFactory.initElements(driver, ShoppingCartMainPage.class);
        nopCommerceNikeRunningShoes = PageFactory.initElements(driver, NikeRunningShoesPage.class);
        nopCommerceNikeSB = PageFactory.initElements(driver, NikeSBPage.class);
        nopCommerceFooter = PageFactory.initElements(driver, FooterPage.class);
        nopCommerceSearchMain = PageFactory.initElements(driver, SearchMainPage.class);
        nopCommerceCommon = PageFactory.initElements(driver, CommonPage.class);
    }

    /*
    ##############################################################################
    Method Name: initMortgage
    Method Description: This Method creates Page Object of MainPage class
                        referred to Mortgage Application.
    Method Parameters: void
    Method Return Type: void
    ##############################################################################
     */
    public static void initMortgage(){
        mortgageMain = new pageObjects.mortgage.MainPage(mobileDriver);
    }

    /*
    ##############################################################################
    Method Name: initTodoList
    Method Description: This Method Initializes elements and return Page Object
                        of MainPage class referred to TodoList Application.
    Method Parameters: void
    Method Return Type: void
    ##############################################################################
     */
    public static void initTodoList(){
        todoListMain = PageFactory.initElements(driver, pageObjects.todoList.MainPage.class);
    }

    /*
    ##############################################################################
    Method Name: initCalculator
    Method Description: This Method Initializes elements and return Page Object
                        of MainPage class referred to Calculator Application.
    Method Parameters: void
    Method Return Type: void
    ##############################################################################
     */
    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
