package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.pages.MyAccountPage;

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
    public static void clickCartQuantity(){
        myAccountPage.clickQuantity();
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
}
