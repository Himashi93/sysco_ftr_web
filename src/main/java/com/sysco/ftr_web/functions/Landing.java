package com.sysco.ftr_web.functions;

import com.sysco.ftr_web.common.Constants;
import com.sysco.ftr_web.pages.LandingPage;
import com.sysco.ftr_web.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Landing {
    public static LandingPage landingPage=new LandingPage();

    public static void loadLandingPage() {
        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            landingPage.loadLoginPage(capabilities, Constants.APP_URL);
        } else {
            landingPage.loadLoginPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

  /*  public static void loadLandingPage(SyscoLabUI syscoLabUI, String url) {
        landingPage = new LandingPage();
        LandingPage.loadLandingPage(syscoLabUI, url);
    }*/
    public static void clickDrpDay(){
        landingPage.clickDrpDay();
    }
    public static void clickDrpMonth(){
        landingPage.clickDrpMonth();
    }
    public static void clickDrpYear(){
        landingPage.clickDrpYear();
    }
    public static void clickFirstDate(){
        landingPage.clickFirstDay();
    }
    public static void clickJanuaryMonth(){
        landingPage.clickMonthJanuary();
    }
    public static void clickTwoThousandThreeYear(){
        landingPage.clickYearTwoThousandThree();
    }

    public static void clickNineteenNinetyThreeYear(){
        landingPage.clickYearNineteenNinetyThree();
    }
    public static void clickRememberMe(){
        landingPage.clickChkRememberMe();
    }
    public static void clickEnter()  {
        landingPage.clickBtnEnter();
    }
    public static String getMessage(){
        return landingPage.getMessage();
    }
    public static void deleteAllCookies(){
        landingPage.deleteAllCookies();
    }
    public static void clickMyAccount(){
        landingPage.clickLnkMyAccount();

    }
//public void validateBdayForAgeEighteenPlus(){
//    landingPage.clickDrpDay();
//    landingPage.clickFirstDay();
//    landingPage.clickDrpMonth();
//    landingPage.clickMonthJanuary();
//    landingPage.clickDrpYear();
//    landingPage.clickYearNineteenNinetyThree();
//}





}
