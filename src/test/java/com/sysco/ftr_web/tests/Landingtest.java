package com.sysco.ftr_web.tests;

import com.sysco.ftr_web.functions.Landing;
import com.sysco.ftr_web.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class Landingtest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Landing");
    }

    @Test(description = "TC-1", alwaysRun = true,groups = {DONT_QUIT_BROWSER})
    public static void testMessageIsDisplayedForAgeLessThanTwentyFourYears() {
        Landing.deleteAllCookies();
        Landing.loadLandingPage();
        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickDrpYear();
        Landing.clickTwoThousandThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        String message="Sorry, your age or location does not permit you to enter at this time.";
        softAssert.assertEquals(Landing.getMessage(),message,"Incorrect Message");
        softAssert.assertAll();
    }
    @Test(description = "TC-2", alwaysRun = true,groups = {USE_CURRENT_BROWSER, DONT_QUIT_BROWSER},dependsOnMethods = "testMessageIsDisplayedForAgeLessThanTwentyFourYears")
    public static void testUserIsNavigatedToLoginPageWhenTheAgeIsGreaterThanTwentyFourYears() {
        Landing.deleteAllCookies();
        Landing.loadLandingPage();
        SoftAssert softAssert = new SoftAssert();
        Landing.clickDrpDay();
        Landing.clickFirstDate();
        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickDrpYear();
        Landing.clickNineteenNinetyThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        String message="Sorry, your age or location does not permit you to enter at this time.";
        softAssert.assertEquals(Landing.getMessage(),message,"Incorrect Message");
        softAssert.assertAll();
    }




//verifyUserIsable to proceedthrough when the age is greater than 18 years
}
