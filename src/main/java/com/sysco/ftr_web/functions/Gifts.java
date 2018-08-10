package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.pages.GiftsPage;

public class Gifts {
    private static GiftsPage giftsPage=new GiftsPage();

    public static void  waitTillGiftsPageLoaded(){
        giftsPage.waitTillGiftsPageLoaded();
    }
    public static void clickCanCooler(){
        giftsPage.clickCanCooler();
    }

    public static void quitDriver(){
       giftsPage.quitDriver();
    }

}
