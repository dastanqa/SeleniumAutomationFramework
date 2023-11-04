package com.dastan.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.dastan.driver.DriverManager;
import com.dastan.enums.ConfigProperties;
import com.dastan.utilities.PropertyUtils;
import com.dastan.utilities.ScreenshotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {
    private ExtentLogger(){
    }

    public static void pass(String message){
        ExtentManager.getExtTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getExtTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getExtTest().skip(message);
    }
    public static void pass(String message,boolean isScreenshotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")&&
        isScreenshotNeeded){
            ExtentManager.getExtTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else pass(message);
    }

    public static void fail(String message,boolean isScreenshotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")&&
                isScreenshotNeeded){
            ExtentManager.getExtTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else fail(message);
    }
    public static void skip(String message,boolean isScreenshotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")&&
                isScreenshotNeeded){
            ExtentManager.getExtTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else skip(message);
    }

}
