package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.pages.CheckOutFirstPage;

public class CheckOutFirst  {
    private static CheckOutFirstPage checkOutFirstPage=new CheckOutFirstPage();
    public static String getFirstName(){
        return checkOutFirstPage.getFirstName();
    }
    public static String getLastName(){
        return checkOutFirstPage.getLastName();
    }

    public static void clearAddressOne(){
        checkOutFirstPage.clearAddressOne();
    }

    public static void clearTelephone(){
        checkOutFirstPage.clearContactNumber();
    }
    public static void clearPostCode(){
        checkOutFirstPage.clearPostCode();
    }

    public static void clickContinue(){
        checkOutFirstPage.clickBtnContinue();
    }
    public static String getAddressRequiredMsg(){
        return checkOutFirstPage.getAddressRequiredMsg();
    }
    public static String getContactNumberRequiredMsg(){
        return checkOutFirstPage.getContactNumberRequiredMsg();
    }

    public static String getPostCodeMsg(){
        return checkOutFirstPage.getPostCodeRequiredMsg();
    }
    public static void clickBtnCloseOfPostalCode(){
        checkOutFirstPage.clickBtnCloseOfPostalCode();
    }

    public static void setPostalCode(){
        checkOutFirstPage.setPostalCode();

    }
    public static String getDeliveryOptionsTitle(){
        return checkOutFirstPage.getDeliveryOptionsTitle();


    }
    public static String getDeliveryOptions(){
        return checkOutFirstPage.getDeliveryOptionsText();
    }

    public static void waitTillPaymentInforLoaded(){
        checkOutFirstPage.waitTillPaymentInforLoaded();
    }
    public static void clickRdbCreditCard(){
        checkOutFirstPage.clickRdbCreditCard();
    }
    public static void enterCreditCardNumber(String testCreditCardNumber){
        checkOutFirstPage.enterCreditCartNumber(testCreditCardNumber);
    }
    public static void enterCCV(String testCCV){
        checkOutFirstPage.enterCCV(testCCV);
    }
    public static void clickChkAgreement(){
        checkOutFirstPage.clickChkAgreement();
    }
    public static void clickPurchaseMyOrder(){
        checkOutFirstPage.clickBtnPurchaseMyOrder();
    }
    public static String getInvalidCreditCardNumberMessage(){
        return checkOutFirstPage.getInvalidCreditCardNumberMessage();
    }

}
