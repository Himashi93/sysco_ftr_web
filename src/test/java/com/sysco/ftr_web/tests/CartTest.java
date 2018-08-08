package com.sysco.ftr_web.tests;

import com.sysco.ftr_web.functions.*;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest {
    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Cart");
        CustomerLogin.loginUsingValidCredentials();
        MyAccount.waitTillMyAccountPageLoaded();
    }

    @Test(description = "TC-10", alwaysRun = true)
    public static void testAddedProductOnCart() {
        SoftAssert softAssert = new SoftAssert();
        MyAccount.clickCartQuantity();
        String productName = "Bundaberg Can Cooler - Yellow";
        String productPrice = "$9.95";
        softAssert.assertEquals(CanCooler.getTxtCanCooler(), productName, "Product name mismatch");
        softAssert.assertEquals(CanCooler.getCanCoolerPrice(), productPrice, "Product price mismatch");
        softAssert.assertAll();

    }

    @Test(description = "TC-11", alwaysRun = true, dependsOnMethods = "testAddedProductOnCart")
    public static void testProceedToCheckoutAndVerifyFirstNameAndLastName() {
        SoftAssert softAssert = new SoftAssert();
        CanCooler.clickCheckout();
        Cart.waitTillCartPageLoaded();
        Cart.clickProceedToCheckout();
        String firstName = "william";
        String lastName = "jacob";
        softAssert.assertEquals(CheckOutFirst.getFirstName(), firstName, "Incorrect first name");
        softAssert.assertEquals(CheckOutFirst.getLastName(), lastName, "Incorrect last name");
        softAssert.assertAll();

    }

    @Test(description = "TC-12", alwaysRun = true, dependsOnMethods = "testProceedToCheckoutAndVerifyFirstNameAndLastName")
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

    @Test(description = "TC-13", alwaysRun = true, dependsOnMethods = "testProceedToCheckoutAndVerifyFirstNameAndLastName")
    public static void testContinueButtonFunctionalityAddingValidPostalCode() {
        SoftAssert softAssert = new SoftAssert();
        CheckOutFirst.clickBtnCloseOfPostalCode();
        CheckOutFirst.setPostalCode();
        CheckOutFirst.clickContinue();
        String deliveryOptionsTitle = "Delivery Options";
        softAssert.assertEquals(CheckOutFirst.getDeliveryOptionsTitle(), deliveryOptionsTitle, "IncorrectTitle");
        softAssert.assertAll();
    }

    @Test(description = "TC-14", alwaysRun = true, dependsOnMethods = "testProceedToCheckoutAndVerifyFirstNameAndLastName")
    public static void testVerifyDeliveryOptions() {
        SoftAssert softAssert = new SoftAssert();
        String flateRate = "Flate Rate $15.00";
        softAssert.assertEquals(CheckOutFirst.getDeliveryOptions(), flateRate, "Invalid Delivery options");
        CheckOutFirst.clickContinue();
        CheckOutFirst.waitTillPaymentInforLoaded();
        softAssert.assertAll();
    }

    @Test(description = "TC-15", alwaysRun = true, dependsOnMethods = "testProceedToCheckoutAndVerifyFirstNameAndLastName")
    public static void testUserIsAbleToProceedWithEmptyCreditCardAndCCVOptions() {
        SoftAssert softAssert = new SoftAssert();
        CheckOutFirst.clickRdbCreditCard();
        CheckOutFirst.enterCreditCardNumber("");
        CheckOutFirst.enterCCV("");
        CheckOutFirst.clickChkAgreement();
        softAssert.assertAll();
    }

    @Test(description = "TC-16", alwaysRun = true, dependsOnMethods = "testProceedToCheckoutAndVerifyFirstNameAndLastName")
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
