package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {

    /*
    #############################################################################
    Method Name: MainPage Constructor
    Method Description: The Constructor Initializes elements of this Page Class.
    Method Parameters: AppiumDriver
    #############################################################################
     */
    public MainPage(AppiumDriver mobileDriver){
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver,3, TimeUnit.SECONDS),this); // Line needs to be remarked while testing Desktop Apps
    }

    @iOSFindBy(id="etAmount")
    @AndroidFindBy(id="etAmount")
    private MobileElement txt_amount;

    @iOSFindBy(id="etTerm")
    @AndroidFindBy(id="etTerm")
    private MobileElement txt_term;

    @iOSFindBy(id="etRate")
    @AndroidFindBy(id="etRate")
    private MobileElement txt_rate;

    @iOSFindBy(id="add_schedule_text")
    @AndroidFindBy(id="add_schedule_text")
    private MobileElement btn_calculate;

    @iOSFindBy(id="tvRepayment")
    @AndroidFindBy(id="tvRepayment")
    private MobileElement txt_repayment;


    /*
    #############################################################################
    Methods Names: Getters
    Method Description: This Methods return MobileElements of this Page Class.
    Method Parameters: void
    Method Return Type: MobileElement
    #############################################################################
     */

    public MobileElement getTxt_amount(){
        return txt_amount;
    }

    public MobileElement getTxt_term(){
        return txt_term;
    }

    public MobileElement getTxt_rate(){
        return txt_rate;
    }

    public MobileElement getBtn_calculate(){
        return btn_calculate;
    }

    public MobileElement getTxt_repayment(){
        return txt_repayment;
    }

}
