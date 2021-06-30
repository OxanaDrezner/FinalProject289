package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;


@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - Verify Addition Command")
    @Description("This test sums numbers and Verifies the Result")
    public void Test01_verifyAdditionCommand(){
        DesktopFlows.calculateAddition(Integer.parseInt(getData("FirstNumber")),Integer.parseInt(getData("SecondNumber")));
        Verifications.assertTextInElement(calcMain.getField_result(),"Display is 9");
    }

}
