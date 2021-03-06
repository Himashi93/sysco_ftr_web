package com.sysco.ftr_web.pages;

import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;


public class MyAccountPage extends CustomerLoginPage {
    private By lblMyBundyAccount = By.xpath("//h1[text()='My Bundy Account']");
    private By msgeWelcome = By.xpath("//div[@class='welcome-msg']/h2");
    private By lblUsername = By.xpath("//p[contains(text(),'william')]");
    private By lnkCartQuantity = By.xpath("//ul[@id='quick-access-list']/li[2]/ul/li[3]/div/div[1]/span[2]");
    private By drpDwnProducts = By.xpath("//a[contains(text(),'Products')]");
    private By lnkGifts = By.xpath("//div[@id='nav-wrapper']/div/div[4]/div[1]/div[2]/ul/li[2]/a");
    private By lnkLogout = By.xpath("//a[@title='Logout']");
    private By lnkMyAccount = By.xpath("//a[@title='My Account']");


    private By lblEmptyCart = By.className("cart-empty");
    private By lnkRemove = By.className("btn-remove");
    private By lnkFirstRemove = By.xpath("//*[@id=\"mini-cart\"]/li[1]/div/div/a[2]");


    public String getWelcomeMessage() {
        return bunderbergUI.getText(msgeWelcome);

    }

    public String getUsernameAndEmail() {
        return bunderbergUI.getText(lblUsername);

    }

    public String getCartQuantityAsString() {
        return bunderbergUI.getText(lnkCartQuantity);
    }


    public void clickGifts() {
        bunderbergUI.mouseHover(drpDwnProducts);
        bunderbergUI.click(lnkGifts);
        bunderbergUI.sleep(5);
    }

    public void waitTillMyAccountPageLoaded() {
        bunderbergUI.waitTillElementLoaded(lblMyBundyAccount);
    }

    public void clickLnkLogout() {
        bunderbergUI.click(lnkLogout);
    }

    public void clickLnkMyAccount() {
        bunderbergUI.click(lnkMyAccount);
    }

    public void clickCart() {
        bunderbergUI.click(lnkCartQuantity);
        bunderbergUI.sleep(3);
    }

    public void
    clearCart() throws AWTException {
        if (bunderbergUI.findElements(lblEmptyCart).size() != 0) {
            System.out.print("Cart is empty");
        } else {
            countAndClickRemoveButton();
        }
    }

    public void countAndClickRemoveButton() throws AWTException {
        System.out.print(bunderbergUI.findElements(lnkRemove).size());
        bunderbergUI.click(lnkFirstRemove);
        bunderbergUI.sleep(5);

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        bunderbergUI.sleep(5);
        clickCart();
        clearCart();
    }

    public static void quitDriver() {
        if (bunderbergUI.driver != null)
            bunderbergUI.quit();
    }

}
