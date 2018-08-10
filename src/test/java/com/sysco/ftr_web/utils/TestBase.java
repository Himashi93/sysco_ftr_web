package com.sysco.ftr_web.utils;

import com.sysco.ftr_web.common.Constants;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.mobile.SyscoLabMUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


@Listeners(SyscoLabListener.class)
public class TestBase {
    private SyscoLabListener testListeners;
    protected SyscoLabQCenter syscoLabQCenter;
    public static Properties properties;
    protected SoftAssert softAssert;
    protected static final String USE_CURRENT_BROWSER = "USE CURRENT BROWSER";
    protected static final String DONT_QUIT_BROWSER = "DONT QUIT BROWSER";

    @BeforeClass(alwaysRun = true)
    public void init() {

        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();

        syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
        syscoLabQCenter.setEnvironment(Constants.TEST_ENV);
        syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
        syscoLabQCenter.setClassName(this.getClass().getName());
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        try {
            if (Constants.UPDATE_DASHBOARD)
                SyscoLabReporting.generateJsonFile(SyscoLabListener.getResults(), syscoLabQCenter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @BeforeTest
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }


}







