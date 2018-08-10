package com.sysco.ftr_web.pages;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CheckOutFirstPage extends CustomerLoginPage {

    private By txtFirstName= By.xpath("//input[@id='billing:firstname']");
    private By txtLastName=By.xpath("//input[@id='billing:lastname']");
    private By txtAddressOne=By.xpath("//input[@id='billing:street1']");
    private By txtContactNumber =By.xpath("//input[@name='billing[telephone]']");
    private By txtPostCode=By.id("billing:postcodesuburb");
    private By btnContinue=By.xpath("//span[text()='Continue']");
    private By msgAddressRequired=By.id("advice-required-entry-billing:street1");
    private By msgContactNumberRequired=By.id("advice-required-entry-billing:telephone");
    private By msgPostCode=By.id("advice-required-entry-billing:postcodesuburb");
    private By btnCloseOFPostalCode=By.id("billing:postcodesuburbremove");
    private By  lblDeliveryOptions=By.xpath("//h2[text()='Delivery Options'] ");
    private By lblFlateRate=By.xpath("//label[contains(@for,'s_method_matrixrate_matrixra')] ");
    private By lblSelectPaymentMethod=By.xpath("//label[text()='Select your payment Method:'] ");
    private By rdbCreditCard=By.id("p_method_braintree");
    private By txtCreditCardNumber= By.id("braintree_cc_number");
    private By txtCCV=By.id("braintree_cc_cid");
    private By chkAgreement=By.id("agreement-1");
    private By btnPurchaseMyOrder=By.id("payment-method-button");
    private By msgInvalidCreditCardNumber=By.id("advice-validate-cc-type-autodetect-braintree_cc_number");
    private By btnDeletePostCode=By.xpath("//input[@id='billing:postcodesuburbremove']");
    private By drpDwnFirstTwoHundred =By.xpath("//div[@id='Autocomplete_billing:postcodesuburb']/div[1]");


    public String  getFirstName(){
        return bunderbergUI.getValue(txtFirstName);

    }

    public String  getLastName(){
        return bunderbergUI.getValue(txtLastName);
    }
    public void clearAddressOne(){
        bunderbergUI.clear(txtAddressOne);
    }

    public void clearContactNumber(){
        bunderbergUI.clear(txtContactNumber);
    }
    public void clearPostCode(){
        bunderbergUI.click(btnDeletePostCode);
        bunderbergUI.sleep(5);
    }
    public void clickBtnContinue(){
        bunderbergUI.click(btnContinue);
    }

    public String getAddressRequiredMsg(){
        return bunderbergUI.getText(msgAddressRequired);
    }
    public String getContactNumberRequiredMsg(){
        return bunderbergUI.getText(msgContactNumberRequired);
    }
    public String getPostCodeRequiredMsg(){
        return bunderbergUI.getText(msgPostCode);
    }

    public void  clickBtnCloseOfPostalCode(){
        bunderbergUI.click(btnCloseOFPostalCode);

    }
    public  void setPostalCode() throws AWTException {

        bunderbergUI.sendKeys(txtPostCode,"2000");
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        bunderbergUI.click(drpDwnFirstTwoHundred);
        bunderbergUI.sleep(5);
        bunderbergUI.click(btnContinue);
        bunderbergUI.sleep(5);



    }
    public String getDeliveryOptionsTitle(){return bunderbergUI.getText(lblDeliveryOptions);
    }
    public String getDeliveryOptionsText(){
        return bunderbergUI.getText(lblFlateRate);
    }

    public void waitTillPaymentInforLoaded(){
        bunderbergUI.waitTillElementLoaded(lblSelectPaymentMethod);
    }

    public void clickRdbCreditCard(){
        bunderbergUI.click(rdbCreditCard);
    }
    public void enterCreditCartNumber(String cCNumber){
        bunderbergUI.sendKeys(txtCreditCardNumber,cCNumber);
    }

    public void enterCCV(String cCV){
        bunderbergUI.sendKeys(txtCCV,cCV);
    }

    public void clickChkAgreement(){
        bunderbergUI.click(chkAgreement);
    }

    public void clickBtnPurchaseMyOrder(){
        bunderbergUI.click(btnPurchaseMyOrder);
    }
    public String getInvalidCreditCardNumberMessage(){
        return bunderbergUI.getText(msgInvalidCreditCardNumber);
    }

    public void setAddressOne(){
        bunderbergUI.sendKeys(txtAddressOne,"abcd");
        bunderbergUI.sleep(5);

    }

    public void setContactNumber(){
        bunderbergUI.sendKeys(txtContactNumber,"94710996370");
        bunderbergUI.sleep(5);

    }
    public static void quitDriver() {
        if (bunderbergUI != null) {
            bunderbergUI.quit();
        }
    }


}

