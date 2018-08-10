package com.sysco.ftr_web.tests;


import com.sysco.ftr_web.functions.Cart;
import com.sysco.ftr_web.functions.CustomerLogin;
import com.sysco.ftr_web.functions.Landing;
import com.sysco.ftr_web.functions.MyAccount;
import com.sysco.ftr_web.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.UnsupportedEncodingException;

@Listeners(SyscoLabListener.class)
public class MyAccountTest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "MyAccount");
        syscoLabQCenter.setClassName(MyAccountTest.class.getName());
        Landing.loadLandingPage();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickDrpYear();
        Landing.clickNineteenNinetyThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        //CustomerLogin.waitTillHomePageIsLoaded();
        Landing.clickMyAccount();

        CustomerLogin.loginUsingValidCredentials();
        MyAccount.waitTillMyAccountPageLoaded();
    }

    @Test(description = "TC-8", alwaysRun = true,groups = {USE_CURRENT_BROWSER, DONT_QUIT_BROWSER})
    public static void testCorrectUserNameIsDisplayed() {

        SoftAssert softAssert = new SoftAssert();
        String usernameAndEmail="william jacob\nwilliamjacob802@gmail.com";
        softAssert.assertEquals(MyAccount.getUsernameAndEmail(),usernameAndEmail,"Incorrect Username and Email");
        softAssert.assertAll();
    }

    @Test(description = "TC-9", alwaysRun = true,groups = {USE_CURRENT_BROWSER, DONT_QUIT_BROWSER},dependsOnMethods = "testCorrectUserNameIsDisplayed")
    public static void testRemoveCartItemsIfExist() throws AWTException {
        SoftAssert softAssert=new SoftAssert();
        MyAccount.clickCart();
        MyAccount.clearCart();
        softAssert.assertEquals(MyAccount.getCartQuantityAsString(),"0","Cart quantity not equal to 0");
        softAssert.assertAll();
    }

}
