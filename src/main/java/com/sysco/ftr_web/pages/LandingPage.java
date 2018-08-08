package com.sysco.ftr_web.pages;

import com.sysco.ftr_web.common.Constants;
import com.sysco.ftr_web.utils.DateUtils;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

public class LandingPage {

    protected static SyscoLabUI bunderbergUI;
    private static By lblBirthdate = By.xpath("//span[text()='Enter your birthdate:']");
    private By drpDay = By.id("age_select_day");
    private By drpMonth = By.id("age_select_day");
    private By drpYear = By.id("age_select_day");
    private By drpFirstDay = By.xpath("//option[text()='1']");
    private By drpJanuaryMonth = By.xpath("//option[text()='January']");
    private By drpTwoThousandThreeYear = By.xpath("//option[text()='2003']");
    private By drpNineteenNinetyThreeYear = By.xpath("//option[text()='1993']");
    private By chkRememberMe = By.xpath("//span[@class='langable age_remember_me_basic']");
    private By btnEnter = By.id("age_confirm_btn");
    private By lblMessage=By.xpath("//span[contains(text(),'Sorry, your age')]");



    public static void loadLoginPage(Capabilities capabilities, String url) {
        bunderbergUI = new SyscoLabWUI(capabilities);
        bunderbergUI.navigateTo(url);
        bunderbergUI.driver.manage().window().maximize();
    }

/*
    public static void loadLandingPage(Capabilities capabilities) {
        if (Constants.BROWSER_TYPE.equals(Constants.BROWSER_FIREFOX) )
            bunderbergUI = new SyscoLabWUI(capabilities, "FIREFOX");
        else
            bunderbergUI = new SyscoLabWUI(capabilities, "CHROME");
        bunderbergUI.navigateTo(Constants.APP_URL);
        bunderbergUI.driver.manage().window().maximize();
        bunderbergUI.waitTillElementLoaded(lblBirthdate);
    }
*/


/*    public static void loadLandingPage(SyscoLabUI syscoLabUI, String url) {
        LandingPage.bunderbergUI = syscoLabUI;
        bunderbergUI.navigateTo(Constants.BUNDABERGRUM_URL);
        bunderbergUI.driver.manage().window().maximize();
        bunderbergUI.waitTillElementLoaded(lblBirthdate);

    }*/

    public void clickDrpDay() {
        bunderbergUI.click(drpDay);
    }

    public void clickDrpMonth() {
        bunderbergUI.click(drpMonth);
    }

    public void clickDrpYear() {
        bunderbergUI.click(drpYear);
    }

    public void clickFirstDay() {
        bunderbergUI.click(drpFirstDay);
    }

    public void clickMonthJanuary() {
        bunderbergUI.click(drpJanuaryMonth);
    }

    public void clickYearTwoThousandThree() {
        bunderbergUI.click(drpTwoThousandThreeYear);
    }

    public void clickYearNineteenNinetyThree() {
        bunderbergUI.click(drpNineteenNinetyThreeYear);
    }

    public void clickChkRememberMe() {
        bunderbergUI.click(chkRememberMe);
    }

    public void clickBtnEnter() {
        bunderbergUI.click(btnEnter);
    }

    public String getMessage(){
        return bunderbergUI.getText(lblMessage);
    }

    public void deleteAllCookies(){
        bunderbergUI.driver.manage().deleteAllCookies();
    }

    public void setDateTwethyFourYearsFromTheCurrentDate(){
        DateUtils dateUtils=new DateUtils();
        DateUtils.getFutureDate(-1);



    }


}
