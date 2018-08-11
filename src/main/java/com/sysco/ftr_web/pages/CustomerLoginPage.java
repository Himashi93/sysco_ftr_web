package com.sysco.ftr_web.pages;


import org.openqa.selenium.By;


public class CustomerLoginPage extends LandingPage {

    private By lnkMyAccount = By.xpath("//a[@title='My Account']");
    private By txtEmail = By.xpath("//input[@id='email']");
    private By txtPassword = By.xpath("//input[@id='pass']");
    private By btnSignIn = By.xpath("//button[@id='send2']");

    private By msgInvalidCredentials = By.xpath("//span[text()='Invalid login or password.']");
    private By msgEmailRequired = By.id("advice-required-entry-email");
    private By msgPasswordRequired = By.id("advice-required-entry-pass");


    public boolean isLoginButtonEnabled() {
        return bunderbergUI.isClickable(btnSignIn);
    }

    public boolean isEmailTextFieldPresent() {
        return bunderbergUI.isDisplayed(txtEmail);
    }

    public boolean isPasswordTextFieldPresent() {
        return bunderbergUI.isDisplayed(txtPassword);
    }


    public void enterUsername(String username) {
        bunderbergUI.sendKeys(txtEmail, username);
    }

    public void enterPassword(String password) {
        bunderbergUI.sendKeys(txtPassword, password);
    }


    public static void quiteDriver() {
        if (bunderbergUI.driver != null)
            bunderbergUI.quit();
    }

    public void clickBtnLogin() {

        bunderbergUI.click(btnSignIn);
        bunderbergUI.sleep(2);
    }

    public void clickLnkMyAccount() {
        bunderbergUI.click(lnkMyAccount);
    }


    public String getInvalidLoginMessage() {
        return bunderbergUI.getText(msgInvalidCredentials);
    }

    public String getEmailRequiredMessage() {
        return bunderbergUI.getText(msgEmailRequired);
    }

    public String getPasswordRequiredMessage() {
        return bunderbergUI.getText(msgPasswordRequired);
    }

    public void clearTxtEmail() {
        bunderbergUI.clear(txtEmail);
    }

    public void clearTxtPassword() {
        bunderbergUI.clear(txtPassword);
    }

    public void waitTillCustomerLoginPageIsLoaded() {
        bunderbergUI.waitTillElementLoaded(lnkMyAccount);
    }

    public String getMyAccountTitle() {
        return bunderbergUI.getText(lnkMyAccount);
    }


}


