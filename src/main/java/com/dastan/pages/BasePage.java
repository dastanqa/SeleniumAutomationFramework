package com.dastan.pages;

import com.dastan.driver.DriverManager;
import com.dastan.enums.WaitStrategy;
import com.dastan.factories.ExplicitWaitFactory;
import com.dastan.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy,String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.click();
        try {
            ExtentLogger.pass("Clicked "+elementName,true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy,String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        element.sendKeys(value);
        try {
            ExtentLogger.pass("Sent "+value+" successfully to "+elementName,true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String getTitle() {
        return DriverManager.getDriver().getTitle();
    }


}
