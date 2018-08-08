package com.sysco.ftr_web.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

public class CartPage extends CustomerLoginPage {
    protected static SyscoLabUI bunderbergUI;
    private By btnProceedToCheckout= By.xpath("//button[@title='Proceed to Checkout']");
    private By lblMyCart=By.xpath("//h1[text()= 'My Cart']");


    public void clickBtnProceedToChekOut(){
        bunderbergUI.click(btnProceedToCheckout);
    }
    public void waitTillCartPageLoaded(){
        bunderbergUI.waitTillElementLoaded(lblMyCart);
    }
}
