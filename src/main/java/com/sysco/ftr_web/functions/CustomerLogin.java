package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.common.Constants;
import com.sysco.ftr_web.pages.CustomerLoginPage;


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
    public static boolean isLoginButtonEnabled(){
        return customerLoginPage.isLoginButtonEnabled();
    }
    public static boolean isEmailTextFieldDisplayed(){
        return customerLoginPage.isEmailTextFieldPresent();
    }
    public static boolean isPasswordTextFieldDisplayed(){
        return customerLoginPage.isPasswordTextFieldPresent();
    }


    public static void loginUsingValidCredentials() {
        customerLoginPage.enterUsername(Constants.USERNAME);
        customerLoginPage.enterPassword(Constants.PASSWORD);
        customerLoginPage.clickBtnLogin();
    }
    public static void loginUsingInvalidEmail() {
        String invalidEmail="abc@gmail.com";
        customerLoginPage.enterUsername(invalidEmail);
        customerLoginPage.enterPassword(Constants.PASSWORD);
        customerLoginPage.clickBtnLogin();
    }

    public static void loginUsingInvalidPassword() {
        String invalidPassword="123";
        customerLoginPage.enterUsername(Constants.USERNAME);
        customerLoginPage.enterPassword(invalidPassword);
        customerLoginPage.clickBtnLogin();
    }

    public static void loginUsingEmptyCredentials() {
        customerLoginPage.enterUsername("");
        customerLoginPage.enterPassword("");
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

}

