package com.dastan.listeners;

import com.dastan.enums.ConfigProperties;
import com.dastan.utilities.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    private int count = 0;
    private int maxRetries = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        boolean value = false;

        try {
            if (PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {

                value = count < maxRetries;
                count++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
