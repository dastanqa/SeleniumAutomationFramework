package com.dastan.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentManager {

    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtTest() {
        return extTest.get();
    }

    static void setExtTest(ExtentTest test) {
        extTest.set(test);
    }

    static void unload() {
        extTest.remove();
    }
}
