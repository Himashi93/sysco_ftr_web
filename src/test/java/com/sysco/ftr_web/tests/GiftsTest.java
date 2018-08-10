package com.sysco.ftr_web.tests;


import com.sysco.ftr_web.functions.*;
import com.sysco.ftr_web.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.UnsupportedEncodingException;

@Listeners(SyscoLabListener.class)
public class GiftsTest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) throws UnsupportedEncodingException {
        syscoLabQCenter.setModule("report_himashi");
        syscoLabQCenter.setFeature("Bundabergrum - Checkout");
        syscoLabQCenter.setClassName(GiftsTest.class.getName());
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
        // MyAccount.waitTillMyAccountPageLoaded();
    }

    @Test(description = "TC-13", alwaysRun = true)
    public static void testSelectProductAndAddToCart() {

        MyAccount.clickGifts();
        Gifts.waitTillGiftsPageLoaded();
        Gifts.clickCanCooler();
        CanCooler.clickAddToCart();

    }
    @AfterClass
    public static void quitDriver(){
        Gifts.quitDriver();
    }


}


