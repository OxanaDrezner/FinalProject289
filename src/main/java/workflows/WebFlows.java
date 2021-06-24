package workflows;

import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.util.List;


public class WebFlows extends CommonOps {

    @Step("Business Flow: Fill Form Register")
    public static void register(String gender, String firstName, String lastName, String dayOfBirth, String monthOfBirth, String yearOfBirth, String email, String company, String pass) {
        UIActions.click(nopCommerceHeader.getLink_register());
        if (gender.equalsIgnoreCase("male"))
            UIActions.click(nopCommerceRegister.getBtn_male());
        else
            UIActions.click(nopCommerceRegister.getBtn_female());
        UIActions.updateText(nopCommerceRegister.getTxt_firstName(), firstName);
        UIActions.updateText(nopCommerceRegister.getTxt_lastName(), lastName);
        if (!dayOfBirth.equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_dayOfBirth(), dayOfBirth);
        if (!monthOfBirth.equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_monthOfBirth(), monthOfBirth);
        if (!yearOfBirth.equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_yearOfBirth(), yearOfBirth);
        UIActions.updateText(nopCommerceRegister.getTxt_email(), email);
        if (!company.equalsIgnoreCase("null"))
            UIActions.updateText(nopCommerceRegister.getTxt_company(), company);
        if (!nopCommerceRegister.getBtn_newsLetter().isSelected())
            UIActions.click(nopCommerceRegister.getBtn_newsLetter());
        UIActions.updateText(nopCommerceRegister.getTxt_pass(), pass);
        UIActions.updateText(nopCommerceRegister.getTxt_confirmPass(), pass);
        UIActions.click(nopCommerceRegister.getBtn_register());
    }

    @Step("Business Flow: Fill Form Register with DB Credentials")
    public static void registerDB(int idNumber) {
        List<String> credentialsDB = DBActions.getCredentials("SELECT*FROM Employees WHERE ID="+idNumber+"");
        UIActions.click(nopCommerceHeader.getLink_register());
        if (credentialsDB.get(1).equalsIgnoreCase("male"))
            UIActions.click(nopCommerceRegister.getBtn_male());
        else
            UIActions.click(nopCommerceRegister.getBtn_female());
        UIActions.updateText(nopCommerceRegister.getTxt_firstName(), credentialsDB.get(2));
        UIActions.updateText(nopCommerceRegister.getTxt_lastName(), credentialsDB.get(3));
        if(!credentialsDB.get(4).equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_dayOfBirth(), credentialsDB.get(4));
        if(!credentialsDB.get(5).equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_monthOfBirth(), credentialsDB.get(5));
        if(!credentialsDB.get(6).equalsIgnoreCase("null"))
            UIActions.selectFromDropDown(nopCommerceRegister.getSelect_yearOfBirth(), credentialsDB.get(6));
        UIActions.updateText(nopCommerceRegister.getTxt_email(), credentialsDB.get(7));
        if(!credentialsDB.get(8).equalsIgnoreCase("null"))
            UIActions.updateText(nopCommerceRegister.getTxt_company(), credentialsDB.get(8));
        if (!nopCommerceRegister.getBtn_newsLetter().isSelected())
            UIActions.click(nopCommerceRegister.getBtn_newsLetter());
        UIActions.updateText(nopCommerceRegister.getTxt_pass(), credentialsDB.get(9));
        UIActions.updateText(nopCommerceRegister.getTxt_confirmPass(), credentialsDB.get(9));
        UIActions.click(nopCommerceRegister.getBtn_register());
    }

    @Step("Business Flow: Add Product From Shoes List To Cart")
    public static void AddProductFromShoesListToCart(String productName) {
        for (int i = 0; i < nopCommerceShoes.getList_products().size(); i++) {
            if (nopCommerceShoes.getList_products().get(i).findElement(By.xpath(".//h2[@class='product-title']")).getText().equalsIgnoreCase(productName)) {
                UIActions.JSclick(nopCommerceShoes.getList_products().get(i).findElement(By.xpath(".//button[@class='button-2 product-box-add-to-cart-button']")));
                if (productName.equalsIgnoreCase("adidas Consortium Campus 80s Running Shoes")) {
                    UIActions.selectFromDropDown(nopCommerceAdidasRunningShoes.getSelect_shoeSize(), "11");
                    UIActions.JSclick(nopCommerceAdidasRunningShoes.getBtn_addToCart());
                }
                else if (productName.equalsIgnoreCase("Nike Floral Roshe Customized Running Shoes")) {
                    UIActions.JSclick(nopCommerceNikeRunningShoes.getBtn_printNatural());
                    UIActions.JSclick(nopCommerceNikeRunningShoes.getBtn_addToCart());
                }
                break;
            }
            else if (i == nopCommerceShoes.getList_products().size() - 1)
                throw new RuntimeException("The Requested Product Does Not Exist in The Shoe Collection");
        }
    }

    @Step("Business Flow: Check if the Product Price Sorting is: Low to High")
    public static boolean isProductListPriceSorting_LtoH(List<WebElement> productList){
        wait.until(ExpectedConditions.attributeContains(nopCommerceCommon.getProductContainerAjax(),"style","display: none;"));
        boolean isLtoH = true;
        for (int i=0;i<productList.size()-1;i++){
            if (Double.parseDouble(productList.get(i).findElement(By.xpath(".//span[@class='price actual-price']")).getText().substring(1))<=Double.parseDouble(productList.get(i+1).findElement(By.xpath(".//span[@class='price actual-price']")).getText().substring(1)))
                continue;
            else{
                isLtoH = false;
                break;
            }
        }
        return isLtoH;
    }

    @Step("Business Flow: Delete Last Product From Cart")
    public static void DeleteLastProductFromCart() {
        UIActions.JSclick(nopCommerceHeader.getLink_cart());
        if (!nopCommerceCartMain.getList_productsInTheCart().isEmpty()) {
            UIActions.JSclick(nopCommerceCartMain.getList_productsInTheCart().get(nopCommerceCartMain.getList_productsInTheCart().size() - 1).findElement(By.className("remove-btn")));
        }
        else
            throw new RuntimeException("The Cart is Empty");
    }

    @Step("Business Flow: Search And Verify Product")
    public static void searchAndVerifyProduct(String productName,String shouldExist){
        UIActions.updateText(nopCommerceHeader.getTxt_search(),productName);
        UIActions.click(nopCommerceHeader.getBtn_search());
        if (shouldExist.equalsIgnoreCase("exist"))
            Verifications.assertSingleAndOnlyExistenceOfSpecifiedRecordInList(nopCommerceSearchMain.getList_productsTitles(),productName);
        else if(shouldExist.equalsIgnoreCase("not-exist"))
            Verifications.assertListIsEmpty(nopCommerceSearchMain.getList_products());
        else
            throw new RuntimeException("Invalid Expected Output Value,should be exist or not-exist");
    }

    @Step("Empty Cart")
    public static void emptyShoppingCart() {
        if (!nopCommerceHeader.getLink_cart().findElement(By.xpath("//span[@class='cart-qty']")).getText().equals("(0)")) {
            UIActions.click(nopCommerceHeader.getLink_cart());
            for (int i = 0; i < nopCommerceCartMain.getList_productsInTheCart().size(); i++) {
                UIActions.JSclick(nopCommerceCartMain.getBtn_remove());
            }
        }
    }

}

