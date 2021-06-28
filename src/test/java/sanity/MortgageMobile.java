package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {

    @Test(description = "Test01 - Verify Mortgage", dataProvider = "data-provider-mobile", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test fills in Mortgage Form and Verifies the Result Calculation (using DDT)")
    public void Test01_verifyMortgage(String amount,String term, String rate, String repayment) {
        MobileFlows.calculateMortgage(amount,term,rate);
        Verifications.assertTextInElement(mortgageMain.getTxt_repayment(), repayment);
    }
}
