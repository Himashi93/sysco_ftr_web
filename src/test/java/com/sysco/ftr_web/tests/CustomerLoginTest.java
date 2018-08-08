package com.sysco.ftr_web.tests;

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

@Listeners(SyscoLabListener.class)
public class CustomerLoginTest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "CustomerLogin");
        Landing.loadLandingPage();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickDrpYear();
        Landing.clickNineteenNinetyThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
    }

    @Test(description = "TC-2", alwaysRun = true)
    public static void verifyUIComponenetsOfMyAccountPage() {
        //CustomerLogin.waitTillCustomerLoginPageLoaded();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue( CustomerLogin.isLoginButtonDisplayed(),"Login button in not displayed");
        softAssert.assertTrue( CustomerLogin.isLoginButtonEnabled(),"Login button in not enabled");
        softAssert.assertTrue(CustomerLogin.isEmailTextFieldDisplayed(),"Email text field is not visible");
        softAssert.assertTrue(CustomerLogin.isPasswordTextFieldDisplayed(),"Password text field is not visible");
        softAssert.assertAll();

    }

    @Test(description = "TC-3", alwaysRun = true)
    public static void verifyUserCanLoginUsingValidCredentials() {
        SoftAssert softAssert=new SoftAssert();
       // CustomerLogin.waitTillCustomerLoginPageLoaded();
        CustomerLogin.loginUsingValidCredentials();
        String welcomeMessage="HELLO, WILLIAM JACOB!";
        softAssert.assertEquals(MyAccount.getWelcomeMessage(),welcomeMessage,"Customer was not successfully logged in");
        softAssert.assertAll();

    }
    @Test(description = "TC-4", alwaysRun = true)
    public static void testUserLoginUsingInvalidEmail() {
        SoftAssert softAssert=new SoftAssert();
        //CustomerLogin.waitTillCustomerLoginPageLoaded();
        CustomerLogin.loginUsingInvalidEmail();
        String loginMessage="Invalid login or password.";
        softAssert.assertEquals(CustomerLogin.getInvalidCredentialsMessage(),loginMessage,"Invalid message");
        softAssert.assertAll();

    }
    @Test(description = "TC-5", alwaysRun = true)
    public static void testUserLoginUsingInvalidPassword() {
        SoftAssert softAssert=new SoftAssert();
        //CustomerLogin.waitTillCustomerLoginPageLoaded();
        CustomerLogin.loginUsingInvalidPassword();
        String loginMessage="Invalid login or password.";
        softAssert.assertEquals(CustomerLogin.getInvalidCredentialsMessage(),loginMessage,"Invalid message");
        softAssert.assertAll();

    }

    @Test(description = "TC-6", alwaysRun = true)
    public static void testUserLoginUsingEmptyCredentials() {
        SoftAssert softAssert=new SoftAssert();
        //CustomerLogin.waitTillCustomerLoginPageLoaded();
        CustomerLogin.loginUsingEmptyCredentials();
        String msgeRequiredField="This is a required field.";
        softAssert.assertEquals(CustomerLogin.getEmailRequiredMessage(),msgeRequiredField,"Invalid message");
        softAssert.assertEquals(CustomerLogin.getPasswordRequiredMessage(),msgeRequiredField,"Invalid message");
        softAssert.assertAll();

    }


}
