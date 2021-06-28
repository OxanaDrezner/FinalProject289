package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;



@Listeners(utilities.Listeners.class)
public class NopCommerceWEB extends CommonOps {

    @Test(description = "Test01 - Verify Registration")
    @Description("This test registers with credentials and Verifies Log out link appearance")
    public void Test01_verifyRegistration(){
        WebFlows.register(getData("Gender"),getData("FirstName"),getData("LastName"),
                getData("DayOfBirth"),getData("MonthOfBirth"),getData("YearOfBirth"),
                getData("Email"),getData("Company"),getData("Password"));
        Verifications.assertTextInElement(nopCommerceRegister.getTxt_registerConfirmation(),"Your registration completed");
    }

    @Test(description = "Test02 - Verify List Order - Low to High")
    @Description("This test Verifies List order By Price 'Low to High' is correct")
    public void Test02_verifyListOrder_LtoH(){
        UIActions.mouseHover(nopCommerceHeader.getLink_apparel(),nopCommerceHeaderApparelMenu.getLink_shoes());
        UIActions.selectFromDropDown(nopCommerceShoes.getSelect_orderBy(),"Price: Low to High");
        Verifications.assertCondition(WebFlows.isProductListPriceSorting_LtoH(nopCommerceShoes.getList_products()));
    }

    @Test(description = "Test03 - Verify Addition To Cart")
    @Description("This test adds product from Shoes List to Cart and Verifies it's Addition")
    public void Test03_verifyAdditionToCart(){
        UIActions.mouseHover(nopCommerceHeader.getLink_apparel(),nopCommerceHeaderApparelMenu.getLink_shoes());
        WebFlows.AddProductFromShoesListToCart("adidas Consortium Campus 80s Running Shoes");
        UIActions.click(nopCommerceHeader.getLink_cart());
        Verifications.assertNumberOfElementsInList(nopCommerceCartMain.getList_productsInTheCart(),1);
    }

    @Test(description = "Test04 - Verify Deletion Last Product From Cart")
    @Description("This test adds product from Shoes List to Cart,Deletes Last Product from Cart and Verifies it's Deletion")
    public void Test04_verifyDeletionLastProductFromCart(){
        UIActions.mouseHover(nopCommerceHeader.getLink_apparel(),nopCommerceHeaderApparelMenu.getLink_shoes());
        WebFlows.AddProductFromShoesListToCart("Nike SB Zoom Stefan Janoski \"Medium Mint\"");
        WebFlows.DeleteLastProductFromCart();
        Verifications.assertNumberOfElementsInList(nopCommerceCartMain.getList_productsInTheCart(),0);
    }

    @Test(description = "Test05 - Verify Social Media Links")
    @Description("This test Verifies The Social Media Links are Displayed (using Soft Assertion)")
    public void Test05_verifySocialMediaLinks(){
        Verifications.softAssertVisibilityOfElements(nopCommerceFooter.getList_socialLinks());
    }

    @Test(description = "Test06 - Verify LOGO")
    @Description("This test Verifies The LOGO of The AUT (using Sikuli tool)")
    public void Test06_verifyLOGO(){
        Verifications.assertElementVisually("LOGO_NopCommerce");
    }

    @Test(description = "Test07 - Search And Verify Products", dataProvider = "data-provider-web", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test Searches And Verifies Products (using DDT)")
    public void Test07_searchAndVerifyProducts(String productName,String shouldExist){
        WebFlows.searchAndVerifyProduct(productName,shouldExist);
    }

}
