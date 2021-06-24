package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String amount,String term, String rate){
        MobileActions.updateText(mortgageMain.getTxt_amount(),amount);
        MobileActions.updateText(mortgageMain.getTxt_term(),term);
        MobileActions.updateText(mortgageMain.getTxt_rate(),rate);
        MobileActions.tap(1,mortgageMain.getBtn_calculate(),500);
    }

    @Step("Clear Text Fields")
    public static void clearTextFields(){
        MobileActions.clearText(mortgageMain.getTxt_amount());
        MobileActions.clearText(mortgageMain.getTxt_term());
        MobileActions.clearText(mortgageMain.getTxt_rate());
    }
}
