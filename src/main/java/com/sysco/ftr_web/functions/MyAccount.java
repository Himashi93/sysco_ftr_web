package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.pages.MyAccountPage;

import java.awt.*;

public class MyAccount {
    private static MyAccountPage myAccountPage = new MyAccountPage();

    private MyAccount() {
    }

    public static String getMyAccountTitle() {
        return myAccountPage.getMyAccountTittle();

    }
    public static String getWelcomeMessage() {
        return myAccountPage.getWelcomeMessage();

    }
    public static String getUsernameAndEmail() {
        return myAccountPage.getUsernameAndEmail();

    }
    public static void clickCart(){
        myAccountPage.clickCart();
    }
    public static void clickRemove(){
        myAccountPage.clickRemoveButton();
    }

    public static void clickGifts(){
        myAccountPage.clickGifts();
    }
    public static void waitTillMyAccountPageLoaded(){
        myAccountPage.waitTillMyAccountPageLoaded();
    }
    public static void clickLogout(){
        myAccountPage.clickLnkLogout();
    }
    public static void clickMyAccount(){
        myAccountPage.clickLnkMyAccount();
    }
    public static String getCartQuantityAsString(){
        return myAccountPage.getCartQuantityAsString();
    }

    public static void clearCart() throws AWTException {
        myAccountPage.clearCart();

    }

}
