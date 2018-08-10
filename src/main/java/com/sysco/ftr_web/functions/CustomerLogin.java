package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.common.Constants;
import com.sysco.ftr_web.pages.CustomerLoginPage;

import java.io.UnsupportedEncodingException;


public class CustomerLogin {



   private static CustomerLoginPage customerLoginPage = new CustomerLoginPage();

    private CustomerLogin() {
    }


    public static void quiteDriver() {
        CustomerLoginPage.quiteDriver();
    }
    public static void clickMyAccount(){
        customerLoginPage.clickLnkMyAccount();
    }

    public static boolean isLoginButtonDisplayed(){
        return customerLoginPage.isLoginButtonVisible();

    }
    public static boolean isLoginButtonEnabled()  {
        return customerLoginPage.isLoginButtonEnabled();
    }
    public static boolean isEmailTextFieldDisplayed(){
        return customerLoginPage.isEmailTextFieldPresent();
    }
    public static boolean isPasswordTextFieldDisplayed(){
        return customerLoginPage.isPasswordTextFieldPresent();
    }


    public static void loginUsingValidCredentials()  {
        customerLoginPage.enterUsername(Constants.USERNAME);
        customerLoginPage.enterPassword(Constants.PASSWORD);
        customerLoginPage.clickBtnLogin();
    }
    public static void loginUsingInvalidEmail() {
        customerLoginPage.clearTxtEmail();
        customerLoginPage.clearTxtPassword();
        String invalidEmail="abc@gmail.com";
        customerLoginPage.enterUsername(invalidEmail);
        customerLoginPage.enterPassword(Constants.PASSWORD);
        customerLoginPage.clickBtnLogin();
    }

    public static void loginUsingInvalidPassword() {
        customerLoginPage.clearTxtEmail();
        customerLoginPage.clearTxtPassword();
        String invalidPassword="123";
        customerLoginPage.enterUsername(Constants.USERNAME);
        customerLoginPage.enterPassword(invalidPassword);
        customerLoginPage.clickBtnLogin();
    }

    public static void loginUsingEmptyCredentials() {
        customerLoginPage.clearTxtEmail();
        customerLoginPage.clearTxtPassword();
        customerLoginPage.clickBtnLogin();
    }


    public static String getInvalidCredentialsMessage(){
        return customerLoginPage.getInvalidLoginMessage();
    }
    public static String getEmailRequiredMessage(){
        return customerLoginPage.getEmailRequiredMessage();
    }
    public static String getPasswordRequiredMessage(){
        return customerLoginPage.getPasswordRequiredMessage();
    }
    public static void waitTillHomePageIsLoaded(){
        customerLoginPage.waitTillHomePageIsLoaded();
    }
    public static void waitTillCustomerLoginPageLoaded(){

        customerLoginPage.waitTillCustomerLoginPageIsLoaded();
    }
    public static String getMyAccountTitle(){
        return customerLoginPage.getMyAccountTitle();

    }
}

