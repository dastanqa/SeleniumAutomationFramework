package com.dastan.tests;

import com.dastan.driver.Driver;
import com.dastan.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Map;

public class BaseTest {

    protected BaseTest() {
    }


    @BeforeMethod
    protected void setUp(Object[] data) throws Exception {
        Map<String,String> map = (Map<String,String>)data[0];
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {

        Driver.quitDriver();
    }
}
