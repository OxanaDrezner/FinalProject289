package sanity;

import org.testng.annotations.Listeners;
import utilities.CommonOps;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import workflows.WebFlows;
import extensions.Verifications;


@Listeners(utilities.Listeners.class)
public class NopCommerceWebDB extends CommonOps {

    @Test(description = "Test01 - Register with DB Credentials and Verify Registration")
    @Description("This test registers with DB credentials and Verifies Registration")
    public void Test01_verifyRegistration(){
        WebFlows.registerDB(1);
        Verifications.assertTextInElement(nopCommerceRegister.getTxt_registerConfirmation(),"Your registration completed");
    }
}
