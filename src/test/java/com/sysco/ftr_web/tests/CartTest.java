package com.sysco.ftr_web.tests;

import com.sysco.ftr_web.functions.*;
import com.sysco.ftr_web.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class CartTest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        syscoLabQCenter.setModule("report_himashi");
        syscoLabQCenter.setFeature("Bundabergrum - Checkout");
        syscoLabQCenter.setClassName(CartTest.class.getName());
        Landing.loadLandingPage();
        Landing.clickDrpDay();
        Landing.clickFirstDate();

        Landing.clickDrpMonth();
        Landing.clickJanuaryMonth();
        Landing.clickDrpYear();

        Landing.clickNineteenNinetyThreeYear();
        Landing.clickRememberMe();
        Landing.clickEnter();
        Landing.clickMyAccount();
        CustomerLogin.loginUsingValidCredentials();
        MyAccount.waitTillMyAccountPageLoaded();
        MyAccount.clickGifts();
        Gifts.waitTillGiftsPageLoaded();
        Gifts.clickCanCooler();
        CanCooler.clickAddToCart();
    }

    @Test(description = "TC-14", alwaysRun = true)
    public static void testAddedProductOnCart() {
        SoftAssert softAssert = new SoftAssert();
        MyAccount.clickCart();
        String productName = "BUNDABERG CAN COOLER - YELLOW";
        String productPrice = "$9.95";
        softAssert.assertEquals(CanCooler.getTxtCanCooler(), productName, "Product name mismatch");
        softAssert.assertEquals(CanCooler.getCanCoolerPrice(), productPrice, "Product price mismatch");
        softAssert.assertAll();

    }

    @Test(description = "TC-15", alwaysRun = true, dependsOnMethods = "testAddedProductOnCart")
    public static void testProceedToCheckoutAndVerifyFirstNameAndLastName() {
        SoftAssert softAssert = new SoftAssert();
        CanCooler.clickCheckout();
        Cart.clickProceedToCheckout();
        String firstName = "william";
        String lastName = "jacob";
        softAssert.assertEquals(CheckOut.getFirstName(), firstName, "Incorrect first name");
        softAssert.assertEquals(CheckOut.getLastName(), lastName, "Incorrect last name");
        softAssert.assertAll();

    }

    @Test(description = "TC-16", alwaysRun = true, dependsOnMethods = "testProceedToCheckoutAndVerifyFirstNameAndLastName")
    public static void testContinueButtonFunctionalityWithoutAddingMandatoryFields() {
        SoftAssert softAssert = new SoftAssert();
        CheckOut.clearAddressOne();
        CheckOut.clearTelephone();
        CheckOut.clearPostCode();
        CheckOut.clickDeliveryAddressContinue();
        String msgFieldRequired = "This is a required field.";
        softAssert.assertEquals(CheckOut.getAddressRequiredMsg(), msgFieldRequired, "Incorrect field required message'");
        softAssert.assertEquals(CheckOut.getContactNumberRequiredMsg(), msgFieldRequired, "Incorrect field required message'");
        softAssert.assertEquals(CheckOut.getPostCodeMsg(), msgFieldRequired, "Incorrect field required message'");
        softAssert.assertAll();

    }

    @Test(description = "TC-17", alwaysRun = true, dependsOnMethods = "testContinueButtonFunctionalityWithoutAddingMandatoryFields")
    public static void testContinueButtonFunctionalityAddingValidPostalCode() throws AWTException {
        CheckOut.setAddressOne();
        CheckOut.setContactNumber();
        CheckOut.clearPostCode();
        CheckOut.setPostalCode();
        CheckOut.clickDeliveryAddressContinue();

    }

    @Test(description = "TC-18", alwaysRun = true, dependsOnMethods = "testContinueButtonFunctionalityAddingValidPostalCode")
    public static void testVerifyDeliveryOptions() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(CheckOut.isChkShippingAuthorizedSelected(), "Delivery Options not confirmed");
        CheckOut.clickShippingMethodContinueButton();
        softAssert.assertAll();
    }

    @Test(description = "TC-19", alwaysRun = true, dependsOnMethods = "testVerifyDeliveryOptions")
    public static void testUserIsAbleToProceedWithEmptyCreditCardAndCCVOptions() {
        CheckOut.waitTillPaymentInforLoaded();
        CheckOut.clickRdbCreditCard();
        SoftAssert softAssert = new SoftAssert();
        CheckOut.enterCreditCardNumber("");
        CheckOut.enterCCV("");
        CheckOut.clickChkAgreement();
        CheckOut.clickPurchaseMyOrder();
        softAssert.assertAll();
    }

    @Test(description = "TC-20", alwaysRun = true, dependsOnMethods = "testUserIsAbleToProceedWithEmptyCreditCardAndCCVOptions")
    public static void testUserIsAbleToProceedWithInvalidCreditCardNumber() {
        SoftAssert softAssert = new SoftAssert();
        CheckOut.clickRdbCreditCard();
        String creditCardNumber = "8333300122256789";
        String CCV = "1234";
        CheckOut.clearCreditCardNumber();
        CheckOut.enterCreditCardNumber(creditCardNumber);
        CheckOut.enterCCV(CCV);
        CheckOut.clickChkAgreement();
        CheckOut.clickPurchaseMyOrder();
        String invalidCreditCardNumberMessage = "Please enter a valid credit card number.";
        softAssert.assertEquals(CheckOut.getInvalidCreditCardNumberMessage(), invalidCreditCardNumberMessage, "Message is not correct");
        softAssert.assertAll();
    }

    @AfterClass
    public void quitDriver() {
        CheckOut.quitDriver();
    }


}
