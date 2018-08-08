package com.sysco.ftr_web.pages;

import org.openqa.selenium.By;


public class MyAccountPage extends CustomerLoginPage{
    private By lblMyBundyAccount =By.xpath("//h1[text()='My Bundy Account']");
    private By msgeWelcome=By.xpath("//div[@class='welcome-msg']/h2");
    private By lblUsername=By.xpath("//p[contains(text(),'william')]");
    private By lnkCartQuantity =By.xpath("//span[@class='orange']");
    private By btnRemoveFirst=By.xpath("//a[@class='btn-remove'][1]");
    private By drpProducts=By.xpath("//a[contains(text(),'Products')]");
    private By lnkProducts=By.xpath("//a[contains(text(),'Gifts')]");


    public String getMyAccountTittle(){
        return bunderbergUI.getText(lblMyBundyAccount);

    }
    public String getWelcomeMessage(){
        return bunderbergUI.getText(msgeWelcome);

    }
    public String getUsernameAndEmail(){
        return bunderbergUI.getText(lblUsername);

    }
    public int getCartQuantity(){
        String cartQuantityAsString= bunderbergUI.getText(lnkCartQuantity);
        int cartQuantity=Integer.parseInt(cartQuantityAsString);
        return cartQuantity;
    }

    public void clickQuantity() {
        if (getCartQuantity() > 0) {
            bunderbergUI.click(lnkCartQuantity);
        }
    }
    public void clickRemoveButton(){
        for (int i=1;i<=getCartQuantity();i++){
            bunderbergUI.click(btnRemoveFirst);
            //confirmation
        }
    }
    public void clickGifts(){
        bunderbergUI.mouseHover(drpProducts);
        bunderbergUI.click(lnkProducts);
    }
    public void waitTillMyAccountPageLoaded(){
        bunderbergUI.waitTillElementLoaded(lblMyBundyAccount);
    }


}
