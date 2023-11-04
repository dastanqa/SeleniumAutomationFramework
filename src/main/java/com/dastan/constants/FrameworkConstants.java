package com.dastan.constants;

import com.dastan.enums.ConfigProperties;
import com.dastan.utilities.PropertyUtils;

public class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/executeables/chromedriver.exe";
    private static final String GECKODRIVER = RESOURCESPATH + "/executeables/geckodriver.exe";
    private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
    private static final String JSONCONFIGFILEPATH = RESOURCESPATH + "/config/config.json";
    private static final int EXPLICITWAIT = 10;
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") +"/extent-test-output";
    private static  String extentReportFilePath = "";
    private static final String EXCELPATH = RESOURCESPATH+"/excel/testdata.xlsx";
    private static final String RUNMANAGERSHEET = "RUNMANAGER";
    private static final String ITERATIONSDATASHEET = "DATA";

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }
    public static String getGeckodriver(){
        return GECKODRIVER;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }
    public static int getExplicitwait(){
        return EXPLICITWAIT;
    }
    public static String getJsonconfigfilepath(){
    return JSONCONFIGFILEPATH;
    }

    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }
    private static String createReportPath() throws Exception {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"/index.html";
        }else{
            return EXTENTREPORTFOLDERPATH+"/index.html";
        }
    }
    public static String getExcelpath(){
        return EXCELPATH;
    }
    public static String getRunmanagersheet(){
        return RUNMANAGERSHEET;
    }

    public static String getIterationsdatasheet(){
        return ITERATIONSDATASHEET;
    }

}
