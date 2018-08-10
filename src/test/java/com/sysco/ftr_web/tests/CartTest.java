package com.sysco.ftr_web.tests;

import com.sysco.ftr_web.functions.*;
import com.sysco.ftr_web.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.UnsupportedEncodingException;

public class CartTest extends TestBase {
    @BeforeClass
    public void init(ITestContext iTestContext) throws UnsupportedEncodingException {
        iTestContext.setAttribute("feature", "Cart");
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

        //CustomerLogin.waitTillHomePageIsLoaded();
        Landing.clickMyAccount();
        CustomerLogin.loginUsingValidCredentials();
        MyAccount.waitTillMyAccountPageLoaded();
        MyAccount.clickGifts();
        Gifts.waitTillGiftsPageLoaded();
        Gifts.clickCanCooler();
        CanCooler.clickAddToCart();
    }

    @Test(description = "TC-11", alwaysRun = true)
    public static void testAddedProductOnCart() {
        SoftAssert softAssert = new SoftAssert();
        MyAccount.clickCart();
        String productName = "BUNDABERG CAN COOLER - YELLOW";
        String productPrice = "$9.95";
        softAssert.assertEquals(CanCooler.getTxtCanCooler(), productName, "Product name mismatch");
        softAssert.assertEquals(CanCooler.getCanCoolerPrice(), productPrice, "Product price mismatch");
        softAssert.assertAll();

    }

    @Test(description = "TC-12", alwaysRun = true, dependsOnMethods = "testAddedProductOnCart")
    public static void testProceedToCheckoutAndVerifyFirstNameAndLastName() {
        SoftAssert softAssert = new SoftAssert();
        CanCooler.clickCheckout();
        //Cart.waitTillCartPageLoaded();
        Cart.clickProceedToCheckout();
        String firstName = "william";
        String lastName = "jacob";
        softAssert.assertEquals(CheckOutFirst.getFirstName(), firstName, "Incorrect first name");
        softAssert.assertEquals(CheckOutFirst.getLastName(), lastName, "Incorrect last name");
        softAssert.assertAll();

    }

    @Test(description = "TC-13", alwaysRun = true, dependsOnMethods = "testProceedToCheckoutAndVerifyFirstNameAndLastName")
    public static void testContinueButtonFunctionalityWithoutAddingMandatoryFields() {
        SoftAssert softAssert = new SoftAssert();
        CheckOutFirst.clearAddressOne();
        CheckOutFirst.clearTelephone();
        CheckOutFirst.clearPostCode();
        CheckOutFirst.clickContinue();
        String msgFieldRequired = "This is a required field.";
        softAssert.assertEquals(CheckOutFirst.getAddressRequiredMsg(), msgFieldRequired, "Incorrect field required message'");
        softAssert.assertEquals(CheckOutFirst.getContactNumberRequiredMsg(), msgFieldRequired, "Incorrect field required message'");
        softAssert.assertEquals(CheckOutFirst.getPostCodeMsg(), msgFieldRequired, "Incorrect field required message'");
        softAssert.assertAll();
    }

    @Test(description = "TC-14", alwaysRun = true, dependsOnMethods = "testContinueButtonFunctionalityWithoutAddingMandatoryFields")
    public static void testContinueButtonFunctionalityAddingValidPostalCode() throws AWTException {
        SoftAssert softAssert = new SoftAssert();
        CheckOutFirst.setAddressOne();
        CheckOutFirst.setContactNumber();
        CheckOutFirst.clearPostCode();
        CheckOutFirst.setPostalCode();
        CheckOutFirst.clickContinue();
//        String msgFieldRequired = "This is a required field.";
//        softAssert.assertEquals(CheckOutFirst.getPostCodeMsg(), msgFieldRequired, "IncorrectTitle");
        softAssert.assertAll();
    }

    @Test(description = "TC-15", alwaysRun = true, dependsOnMethods = "testContinueButtonFunctionalityAddingValidPostalCode")
    public static void testVerifyDeliveryOptions() {
        SoftAssert softAssert = new SoftAssert();
        String flateRate = "Flate Rate $15.00";
        softAssert.assertEquals(CheckOutFirst.getDeliveryOptions(), flateRate, "Invalid Delivery options");
        CheckOutFirst.clickContinue();
        CheckOutFirst.waitTillPaymentInforLoaded();
        softAssert.assertAll();
    }

    @Test(description = "TC-16", alwaysRun = true, dependsOnMethods = "testVerifyDeliveryOptions")
    public static void testUserIsAbleToProceedWithEmptyCreditCardAndCCVOptions() {
        SoftAssert softAssert = new SoftAssert();
        CheckOutFirst.clickRdbCreditCard();
        CheckOutFirst.enterCreditCardNumber("");
        CheckOutFirst.enterCCV("");
        CheckOutFirst.clickChkAgreement();
        softAssert.assertAll();
    }

    @Test(description = "TC-17", alwaysRun = true, dependsOnMethods = "testUserIsAbleToProceedWithEmptyCreditCardAndCCVOptions")
    public static void testUserIsAbleToProceedWithInvalidCreditCardNumber() {
        SoftAssert softAssert = new SoftAssert();
        CheckOutFirst.clickRdbCreditCard();
        String creditCardNumber = "333300122256789";
        String CCV = "1234";
        CheckOutFirst.enterCreditCardNumber(creditCardNumber);
        CheckOutFirst.enterCCV(CCV);
        CheckOutFirst.clickChkAgreement();
        CheckOutFirst.clickPurchaseMyOrder();
        String invalidCreditCardNumberMessage = "Credit card type is not allowed for this payment method.";
        softAssert.assertEquals(CheckOutFirst.getInvalidCreditCardNumberMessage(), invalidCreditCardNumberMessage, "Message is not correct");
        softAssert.assertAll();
    }


}
