package com.sysco.ftr_web.pages;


import org.openqa.selenium.By;

public class GiftsPage extends CustomerLoginPage {

    private By lblGifts = By.xpath("//h1[contains(text(),'Gifts')]");
    private By imgCanCooler = By.xpath("//img[@class='product-tag-image product-tag-image-1508']");


    public void waitTillGiftsPageLoaded() {
        bunderbergUI.waitTillElementLoaded(lblGifts);

    }

    public void clickCanCooler() {
        bunderbergUI.click(imgCanCooler);
        bunderbergUI.sleep(5);

    }

    public static void quitDriver() {
        if (bunderbergUI.driver != null)
            bunderbergUI.quit();
    }
}
