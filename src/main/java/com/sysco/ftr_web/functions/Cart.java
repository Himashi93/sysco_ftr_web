package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.pages.CartPage;

public class Cart {
    private static CartPage cartPage=new CartPage();

    public static void clickProceedToCheckout(){
        cartPage.clickBtnProceedToChekOut();

    }
    public static void waitTillCartPageLoaded(){
        cartPage.waitTillCartPageLoaded();
    }
}
