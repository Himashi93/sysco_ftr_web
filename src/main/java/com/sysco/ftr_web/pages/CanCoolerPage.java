package com.sysco.ftr_web.pages;


import org.openqa.selenium.By;

public class CanCoolerPage extends CustomerLoginPage {


    private By btnAddTOCart = By.xpath("//button[@title='Add to Cart']");
    private By lblCanCoolerInCart = By.xpath("//a[text()='Bundaberg Can Cooler - Yellow']");
    private By lblCanCoolerPriceInCart = By.xpath("//span[@class='price']");
    private By btnCheckout = By.xpath("//span[text()='Checkout']");


    public void clickAddToCart() {
        bunderbergUI.click(btnAddTOCart);
    }

    public String getCanCoolerText() {
        return bunderbergUI.getText(lblCanCoolerInCart);
    }

    public String getCanCoolerPrice() {
        return bunderbergUI.getText(lblCanCoolerPriceInCart);
    }

    public void clickBtnCheckout() {
        bunderbergUI.click(btnCheckout);
        bunderbergUI.sleep(3);
    }
}
