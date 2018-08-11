package com.sysco.ftr_web.common;

public class Constants {

    private Constants() {
    }


    public static final String USERNAME = "williamjacob802@gmail.com";
    public static final String PASSWORD = "12345678";


    public static final String TEST_ENV = System.getProperty("test.env", "QA");
    public static final String TEST_RELEASE = System.getProperty("test.release", "report_himashi");
    public static final String TEST_PROJECT = System.getProperty("test.project", "Java Based Web UI Automation");
    public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "true"));
    public static final boolean RUN_LOCALLY = Boolean.parseBoolean(System.getProperty("run.locally", "true"));
    public static final String APP_URL = System.getProperty("app.url", "https://www.bundabergrum.com.au/");
    public static final String APP_OS = System.getProperty("app.os", "WIN10");


}
