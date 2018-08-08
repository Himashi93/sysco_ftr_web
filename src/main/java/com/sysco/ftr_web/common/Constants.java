package com.sysco.ftr_web.common;

public class Constants {

private Constants(){}



 public static final String USERNAME = "williamjacob802@gmail.com";
 public static final String PASSWORD  = "12345678 ";

 public static final boolean KILL_BROWSERS = Boolean.parseBoolean(System.getProperty("kill.browsers", "false"));
 public static final String BIRCH_ST_UN = "SYSCO";
 public static final String BIRCH_ST_PW = "Birch529";
 public static final String BROWSER_FIREFOX = "firefox";
 //public static final String BROWSER_TYPE = System.getProperty("browser.type", "chrome");
 public static final String BROWSER_TYPE="CHROME";
 public static final String COLUMN_TITLE = "COLUMN";
 public static final String VALUE = "value";

 public static final String TEST_ENV = System.getProperty("test.env", "QA");
 public static final String TEST_RELEASE = System.getProperty("test.release", "<release name>");
 public static final String TEST_PROJECT = System.getProperty("test.project", "<project name>");
 public static final boolean UPDATE_DASHBOARD = Boolean.parseBoolean(System.getProperty("update.dashboard", "false"));
 public static final boolean RUN_LOCALLY = Boolean.parseBoolean(System.getProperty("run.locally", "true"));
 public static final String APP_URL = System.getProperty("app.url", "https://www.bundabergrum.com.au/");
 public static final String APP_OS = System.getProperty("app.os", "LINUX");
 public static final String APP_BROWSER = System.getProperty("app.browser", "chrome");



}
