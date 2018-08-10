package com.sysco.ftr_web.pages;

import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;

public class CartPage extends CustomerLoginPage {

    private By btnProceedToCheckout= By.xpath("//button[@title='Proceed to Checkout']");
    private By lblMyCart=By.xpath("//h1[text()= 'My Cart']");


    public void clickBtnProceedToChekOut(){
        bunderbergUI.click(btnProceedToCheckout);
        bunderbergUI.sleep(5);
    }
    public void waitTillCartPageLoaded(){
        bunderbergUI.waitTillElementLoaded(lblMyCart);
    }
}
