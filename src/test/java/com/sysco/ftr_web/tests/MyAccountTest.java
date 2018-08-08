package com.sysco.ftr_web.tests;


import com.sysco.ftr_web.functions.CustomerLogin;
import com.sysco.ftr_web.functions.MyAccount;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class MyAccountTest {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "My Account");
        CustomerLogin.loginUsingValidCredentials();
        MyAccount.waitTillMyAccountPageLoaded();
    }

    @Test(description = "TC-7", alwaysRun = true)
    public static void testCorrectUserNameIsDisplayed() {

        SoftAssert softAssert = new SoftAssert();
        String usernameAndEmail="william jacob\nwilliamjacob802@gmail.com";
        softAssert.assertEquals(MyAccount.getUsernameAndEmail(),usernameAndEmail,"Incorrect Username and Email");
        softAssert.assertAll();
    }

    @Test(description = "TC-8", alwaysRun = true)
    public static void testRemoveCartItemsIfExist() {

        MyAccount.clickCartQuantity();
        MyAccount.clickRemove();
        //assertion for cart item 0
    }

}
