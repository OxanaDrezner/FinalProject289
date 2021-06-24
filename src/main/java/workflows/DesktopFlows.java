package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
import utilities.Functions;

public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Calculate Addition")
    public static void calculateAddition(int num1, int num2) {
        UIActions.click(Functions.calculatorNumbers(num1));
        UIActions.click(calcMain.getBtn_plus());
        UIActions.click(Functions.calculatorNumbers(num2));
        UIActions.click(calcMain.getBtn_equals());
    }

    @Step("Click on 'Clear' button")
    public static void clickOnClearButton() {
        UIActions.click(calcMain.getBtn_clear());
    }

}
