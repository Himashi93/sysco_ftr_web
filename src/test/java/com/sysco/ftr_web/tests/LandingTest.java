package com.sysco.ftr_web.tests;

import com.sysco.ftr_web.functions.CustomerLogin;
import com.sysco.ftr_web.functions.Landing;
import com.sysco.ftr_web.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class LandingTest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        syscoLabQCenter.setModule("report_himashi");
        syscoLabQCenter.setFeature("Bundabergrum - Checkout");
        syscoLabQCenter.setClassName(LandingTest.class.getName());
    }

    @BeforeMethod
    public void deleteCookiesAndLoadLandingPage() {

        Landing.loadLandingPage();

    }

    @Test(description = "TC-1", alwaysRun = true, priority = 1)
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

    @Test(description = "TC-2", dependsOnMethods = "testMessageIsDisplayedForAgeLessThanTwentyFourYears")
    public static void testUserIsNavigatedToLoginPageWithoutEnteringTheYear() {
        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickRememberMe();
        Landing.clickEnter();
        String message = "Please enter your date of birth";
        softAssert.assertEquals(Landing.getMsgBirthDate(), message, "Incorrect Message");
        softAssert.assertAll();
        Landing.deleteAllCookies();
    }

    @Test(description = "TC-3", alwaysRun = true, dependsOnMethods = "testUserIsNavigatedToLoginPageWithoutEnteringTheYear")
    public static void testUserIsNavigatedToLoginPageWithoutEnteringTheMonth() {
        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpYear();
        Landing.clickTwoThousandThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        String message = "Please enter your date of birth";
        softAssert.assertEquals(Landing.getMsgBirthDate(), message, "Incorrect Message");
        softAssert.assertAll();
        Landing.deleteAllCookies();
    }

    @Test(description = "TC-4", alwaysRun = true, dependsOnMethods = "testUserIsNavigatedToLoginPageWithoutEnteringTheYear")
    public static void testUserIsNavigatedToLoginPageWithoutEnteringTheDate() {
        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickDrpYear();
        Landing.clickTwoThousandThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        String message = "Please enter your date of birth";
        softAssert.assertEquals(Landing.getMsgBirthDate(), message, "Incorrect Message");
        softAssert.assertAll();
        Landing.deleteAllCookies();
    }

    @Test(description = "TC-5", alwaysRun = true, dependsOnMethods = "testUserIsNavigatedToLoginPageWithoutEnteringTheMonth")
    public static void testUserIsNavigatedToLoginPageWhenTheAgeIsGreaterThanTwentyFourYears() {
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
        String myAccountTitle = "My Account";
        softAssert.assertEquals(CustomerLogin.getMyAccountTitle(), myAccountTitle, "User not not successfully logged in");
        softAssert.assertAll();
    }

    @AfterTest
    public static void quitDriver() {
        Landing.quitDriver();
    }


}
