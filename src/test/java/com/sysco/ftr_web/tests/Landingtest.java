package com.sysco.ftr_web.tests;

import com.sysco.ftr_web.functions.CustomerLogin;
import com.sysco.ftr_web.functions.Landing;
import com.sysco.ftr_web.functions.MyAccount;
import com.sysco.ftr_web.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class Landingtest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Landing");
        syscoLabQCenter.setClassName(Landingtest.class.getName());
    }

    @BeforeMethod
    public void deleteCookiesAndLoadLandingPage() {

        Landing.loadLandingPage();

    }

    @Test(description = "TC-1", alwaysRun = true, groups = {DONT_QUIT_BROWSER})
    public static void testMessageIsDisplayedForAgeLessThanTwentyFourYears() {
        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickDrpYear();
        Landing.clickTwoThousandThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        String message = "Sorry, your age or location does not permit you to enter at this time.";
        softAssert.assertEquals(Landing.getMessage(), message, "Incorrect Message");
        softAssert.assertAll();
        Landing.deleteAllCookies();
    }
    @Test(description = "TC-2", alwaysRun = true, groups = {USE_CURRENT_BROWSER, DONT_QUIT_BROWSER})
    public static void testUserIsNavigatedToLoginPageWithoutEnteringTheYear()  {

        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickRememberMe();
        Landing.clickEnter();
        String message = "Please enter your date of birth";
        softAssert.assertEquals(Landing.getMessage(), message, "Incorrect Message");
        softAssert.assertAll();
        Landing.deleteAllCookies();
    }

    @Test(description = "TC-2", alwaysRun = true, groups = {USE_CURRENT_BROWSER, DONT_QUIT_BROWSER})
    public static void testUserIsNavigatedToLoginPageWithoutEnteringTheMonth()  {

        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpYear();
        Landing.clickTwoThousandThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        String message = "Please enter your date of birth";
        softAssert.assertEquals(Landing.getMessage(), message, "Incorrect Message");
        softAssert.assertAll();
        Landing.deleteAllCookies();
    }

    @Test(description = "TC-2", alwaysRun = true, groups = {USE_CURRENT_BROWSER, DONT_QUIT_BROWSER})
    public static void testUserIsNavigatedToLoginPageWhenTheAgeIsGreaterThanTwentyFourYears()  {

        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickDrpYear();
        Landing.clickNineteenNinetyThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        CustomerLogin.waitTillCustomerLoginPageLoaded();
        CustomerLogin.waitTillCustomerLoginPageLoaded();
        String myAccountTitle="My Account";
        softAssert.assertEquals(CustomerLogin.getMyAccountTitle(),myAccountTitle,"User not not successfully logged in");
        softAssert.assertAll();
    }





}
