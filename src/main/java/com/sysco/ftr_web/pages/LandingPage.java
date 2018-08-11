package com.sysco.ftr_web.pages;


import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class LandingPage {

    protected static SyscoLabUI bunderbergUI;
    private By drpDwnDay = By.id("age_select_day");
    private By drpDwnMonth = By.id("age_select_day");
    private By drpDwnYear = By.id("age_select_day");
    private By drpDwnFirstDay = By.xpath("//option[text()='1']");
    private By drpDwnJanuaryMonth = By.xpath("//option[text()='January']");
    private By drpDwnTwoThousandThreeYear = By.xpath("//option[text()='2003']");
    private By drpDwnNineteenNinetyThreeYear = By.xpath("//option[text()='1993']");
    private By chkRememberMe = By.xpath("//span[@class='langable age_remember_me_basic']");
    private By btnEnter = By.id("age_confirm_btn");
    private By lblMessage = By.xpath("//span[contains(text(),'Sorry, your age')]");
    private By lnkMyAccount = By.xpath("//a[@title='My Account']");
    private By msgBirthDate = By.xpath("//span[@data-lang='missing_fields']");


    public static void loadLoginPage(Capabilities capabilities, String url) {
        bunderbergUI = new SyscoLabWUI(capabilities);
        bunderbergUI.navigateTo(url);
        bunderbergUI.driver.manage().window().maximize();
    }

    public void clickDrpDay() {
        bunderbergUI.click(drpDwnDay);
    }

    public void clickDrpMonth() {
        bunderbergUI.click(drpDwnMonth);
    }

    public void clickDrpYear() {
        bunderbergUI.click(drpDwnYear);
    }

    public void clickFirstDay() {
        bunderbergUI.click(drpDwnFirstDay);
    }

    public void clickMonthJanuary() {
        bunderbergUI.click(drpDwnJanuaryMonth);
    }

    public void clickYearTwoThousandThree() {
        bunderbergUI.click(drpDwnTwoThousandThreeYear);
    }

    public void clickYearNineteenNinetyThree() {
        bunderbergUI.click(drpDwnNineteenNinetyThreeYear);
    }

    public void clickChkRememberMe() {
        bunderbergUI.click(chkRememberMe);
    }

    public void clickBtnEnter() {
        bunderbergUI.click(btnEnter);
        bunderbergUI.sleep(2);
    }

    public String getMessage() {
        return bunderbergUI.getText(lblMessage);
    }

    public void deleteAllCookies() {
        bunderbergUI.driver.manage().deleteAllCookies();
    }


    public void clickLnkMyAccount() {
        bunderbergUI.click(lnkMyAccount);
        bunderbergUI.sleep(2);
    }

    public String getMsgBirthDtae() {
        return bunderbergUI.getText(msgBirthDate);
    }

    public static void quitDriver() {
        if (bunderbergUI.driver != null)
            bunderbergUI.quit();
    }


}
