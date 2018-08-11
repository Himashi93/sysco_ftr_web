package com.sysco.ftr_web.pages;


import org.openqa.selenium.By;

public class CartPage extends CustomerLoginPage {

    private By btnProceedToCheckout = By.xpath("//button[@title='Proceed to Checkout']");


    public void clickBtnProceedToChekOut() {
        bunderbergUI.click(btnProceedToCheckout);
        bunderbergUI.sleep(5);
    }

}
