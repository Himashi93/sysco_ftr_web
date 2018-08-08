package com.sysco.ftr_web.tests;


import com.sysco.ftr_web.functions.CanCooler;
import com.sysco.ftr_web.functions.CustomerLogin;
import com.sysco.ftr_web.functions.Gifts;
import com.sysco.ftr_web.functions.MyAccount;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class GiftsTest {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Gifts");
        CustomerLogin.loginUsingValidCredentials();
        MyAccount.waitTillMyAccountPageLoaded();
    }

    @Test(description = "TC-9", alwaysRun = true)
    public static void testSelectProductAndAddToCart() {

        MyAccount.clickGifts();
        Gifts.waitTillGiftsPageLoaded();
        Gifts.clickCanCooler();
        CanCooler.waitTillCanCoolerPageLoaded();
        CanCooler.clickAddToCart();

    }




}


