package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.pages.CanCoolerPage;

public class CanCooler {

    private static CanCoolerPage canCoolerPage=new CanCoolerPage();

    public static void waitTillCanCoolerPageLoaded(){
        canCoolerPage.waitTillCanCoolerPageLoaded();
    }
    public static void clickAddToCart(){
        canCoolerPage.clickAddToCart();
    }

    public static String getTxtCanCooler(){
        return canCoolerPage.getCanCoolerText();
    }
    public static String getCanCoolerPrice(){
        return canCoolerPage.getCanCoolerPrice();
    }

    public static void clickCheckout(){
        canCoolerPage.clickBtnCheckout();
    }
}
