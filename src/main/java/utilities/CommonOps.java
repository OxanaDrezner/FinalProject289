package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver; // Line needs to be remarked while testing Mobile Apps
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.DesktopFlows;
import workflows.ElectronFlows;
import workflows.MobileFlows;
import workflows.WebFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{

    /*
    ############################################################################
    Method Name: getData
    Method Description: This Method Extracts data from xml configuration file
    Method Parameters: String
    Method Return Type: String
    ############################################################################
     */
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    /*
    #####################################################################################################
    Method Name: initBrowser
    Method Description: This Method Initializes the Driver with desired Browser Type Driver. Configures
                        Objects and Parameters needed and launches the Browser with defined URL.
    Method Parameters: String
    Method Return Type: void
    #####################################################################################################
     */
    public static void initBrowser(String BrowserType){
        if (BrowserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (BrowserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (BrowserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");

        ManagePages.initNopCommerce();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
        driver.get(getData("url"));
        driver.manage().window().maximize();
    }

    /*
    ################################################################################
    Method Name: initChromeDriver
    Method Description: This Method Sets Up System Property of Updated ChromeDriver
    Method Parameters: void
    Method Return Type: WebDriver
    ################################################################################
     */
    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /*
    ##################################################################################
    Method Name: initFirefoxDriver
    Method Description: This Method Sets Up System Property of Updated FirefoxDriver
    Method Parameters: void
    Method Return Type: WebDriver
    ##################################################################################
     */
    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    /*
    ###########################################################################################
    Method Name: initIEDriver
    Method Description: This Method Sets Up System Property of Updated InternetExplorerDriver
    Method Parameters: void
    Method Return Type: WebDriver
    ###########################################################################################
     */
    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    /*
    ################################################################################################
    Method Name: initMobile
    Method Description: This Method Initializes the Driver with desired Mobile Platform Driver.
                        Configures Objects and Parameters needed and launches the defined Mobile
                        Application.
    Method Parameters: String
    Method Return Type: void
    ################################################################################################
     */
    public static void initMobile(String MobilePlatform){
        dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        if (MobilePlatform.equalsIgnoreCase("Android")) {
            dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
            dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
            try {
                mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
            } catch (Exception e) {
                System.out.println("Can not connect to Appium Server, see details: " + e);
            }
        }
        else if(MobilePlatform.equalsIgnoreCase("IOS")){
            dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getData("BundleID"));
            dc.setCapability("instrumentApp",true);
            try {
                mobileDriver = new IOSDriver(new URL(getData("AppiumServer")), dc);
            } catch (Exception e) {
                System.out.println("Can not connect to Appium Server, see details: " + e);
            }
        }
        else throw new RuntimeException("Invalid Mobile System, should be Android or IOS");

        ManagePages.initMortgage();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver,Long.parseLong(getData("TimeOut")));
    }

    /*
    ##########################################################################################
    Method Name: initAPI
    Method Description: This Method Connects to defined Server and Initializes API Objects.
    Method Parameters: void
    Method Return Type: void
    ##########################################################################################
     */
    public static void initAPI(){
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given();
        params = new JSONObject();
    }

    /*
    #############################################################################################
    Method Name: initElectron
    Method Description: This Method Initializes the Electron Driver. Configures
                        Objects and Parameters needed and launches the Electron Application.
    Method Parameters: void
    Method Return Type: void
    #############################################################################################
     */
    public static void initElectron(){
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc = new DesiredCapabilities();
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);

        ManagePages.initTodoList();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
    }

    /*
    #############################################################################################
    Method Name: initDesktop
    Method Description: This Method Initializes the Windows Driver. Configures
                        Objects and Parameters needed and launches the Desktop Application.
    Method Parameters: void
    Method Return Type: void
    #############################################################################################
     */
    public static void initDesktop() {
        dc = new DesiredCapabilities();
        dc.setCapability("app",getData("DesktopAppPath"));
        try {
            driver = new WindowsDriver(new URL (getData("AppiumServerDesktop")),dc); // Line needs to be remarked while testing Mobile Apps
        } catch (Exception e) {
            System.out.println("Can not connect to Appium Server, see details: " + e);
        }

        ManagePages.initCalculator();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);

    }

    /*
    ################################################################################################
    Method Name: startSession
    Method Description: This Method receives the Platform Name from TestNG Suite and passes the
                        Platform to relevant method.
                        Initializes Objects needed and opens DB connection with given Parameters.
    Method Parameters: String (Using @Parameters)
    Method Return Type: void
    ################################################################################################
     */
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName){
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if(platform.equalsIgnoreCase("mobile"))
            initMobile(getData("MobilePlatform"));
        else if(platform.equalsIgnoreCase("api"))
            initAPI();
        else if(platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid Platform Name");

        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"),getData("DBUserName"),getData("DBPassword"));
    }

    /*
    ##################################################################
    Method Name: closeSession
    Method Description: This Method closes Connection to DB and AUT.
    Method Parameters: void
    Method Return Type: void
    ##################################################################
     */
    @AfterClass
    public void closeSession(){
        ManageDB.closeConnection();
        if(!platform.equalsIgnoreCase("api")){
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }
    }

    /*
    ###############################################################################
    Method Name: afterMethodProcedures
    Method Description: This Method preforms after method actions at the end of
                        each Test of AUT.
    Method Parameters: void
    Method Return Type: void
    ###############################################################################
     */
    @AfterMethod
    public void afterMethodProcedures() {
        if (platform.equalsIgnoreCase("web")) {
            WebFlows.emptyShoppingCart();
            driver.get(getData("url"));
        }
        else if (platform.equalsIgnoreCase("electron")) {
            ElectronFlows.emptyList();
            ElectronFlows.chooseNoTagAndCloseTagMenu();
        }
        else if (platform.equalsIgnoreCase("desktop"))
            DesktopFlows.clickOnClearButton();
        else if (platform.equalsIgnoreCase("mobile"))
            MobileFlows.clearTextFields();
    }

}
