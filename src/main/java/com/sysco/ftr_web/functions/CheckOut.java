package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.pages.CheckOutPage;

import java.awt.*;

public class CheckOut {
    private static CheckOutPage checkOutPage = new CheckOutPage();

    public static String getFirstName() {
        return checkOutPage.getFirstName();
    }

    public static String getLastName() {
        return checkOutPage.getLastName();
    }

    public static void clearAddressOne() {
        checkOutPage.clearAddressOne();
    }

    public static void clearTelephone() {
        checkOutPage.clearContactNumber();
    }

    public static void clearPostCode() {
        checkOutPage.clearPostCode();
    }

    public static void clickDeliveryAddressContinue() {
        checkOutPage.clickBtnDeliveryAddressContinue();
    }

    public static String getAddressRequiredMsg() {
        return checkOutPage.getAddressRequiredMsg();
    }

    public static String getContactNumberRequiredMsg() {
        return checkOutPage.getContactNumberRequiredMsg();
    }

    public static String getPostCodeMsg() {
        return checkOutPage.getPostCodeRequiredMsg();
    }


    public static void setPostalCode() throws AWTException {
        checkOutPage.setPostalCode();

    }


    public static void waitTillPaymentInforLoaded() {
        checkOutPage.waitTillPaymentInforLoaded();
    }

    public static void clickRdbCreditCard() {
        checkOutPage.clickRdbCreditCard();
    }

    public static void enterCreditCardNumber(String testCreditCardNumber) {
        checkOutPage.enterCreditCartNumber(testCreditCardNumber);
    }

    public static void enterCCV(String testCCV) {
        checkOutPage.enterCCV(testCCV);
    }

    public static void clickChkAgreement() {
        checkOutPage.clickChkAgreement();
    }

    public static void clickPurchaseMyOrder() {
        checkOutPage.clickBtnPurchaseMyOrder();
    }

    public static String getInvalidCreditCardNumberMessage() {
        return checkOutPage.getInvalidCreditCardNumberMessage();
    }

    public static void setAddressOne() {
        checkOutPage.setAddressOne();
    }

    public static void setContactNumber() {
        checkOutPage.setContactNumber();
    }

    public static void clearCreditCardNumber() {
        checkOutPage.clearCreditCardNumber();
    }

    public static void clickShippingMethodContinueButton() {
        checkOutPage.clickShippingMethodContinueButton();
    }


    public static boolean isChkShippingAuthorizedSelected() {
        return checkOutPage.isChkShippingAuthorizedSelected();
    }

    public static void quitDriver() {
        checkOutPage.quitDriver();
    }

}
