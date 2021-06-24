package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.nopCommerce.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Base {
    // General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static DesiredCapabilities dc;
    protected static String platform;

    // Web
    protected static WebDriver driver; //Also used with ElectronApp and DesktopApp

    // Mobile
    protected static AppiumDriver mobileDriver;

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params;
    protected static JsonPath jp;

    // Electron
    protected static ChromeOptions opt;

    // Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;
    protected static ResultSetMetaData rsmd;



    // Page Objects - Web
    protected static RegisterPage nopCommerceRegister;
    protected static HeaderPage nopCommerceHeader;
    protected static FooterPage nopCommerceFooter;
    protected static HeaderApparelMenuPage nopCommerceHeaderApparelMenu;
    protected static ShoesPage nopCommerceShoes;
    protected static AdidasRunningShoesPage nopCommerceAdidasRunningShoes;
    protected static ShoppingCartMainPage nopCommerceCartMain;
    protected static NikeRunningShoesPage nopCommerceNikeRunningShoes;
    protected static NikeSBPage nopCommerceNikeSB;
    protected static SearchMainPage nopCommerceSearchMain;
    protected static CommonPage nopCommerceCommon;


    // Page Objects - Mobile
    protected static pageObjects.mortgage.MainPage mortgageMain;

    // Page Objects - Electron
    protected static pageObjects.todoList.MainPage todoListMain;

    // Page Objects - Desktop
    protected static pageObjects.calculator.MainPage calcMain;

}
