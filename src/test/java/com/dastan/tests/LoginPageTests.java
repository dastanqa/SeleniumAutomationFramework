package com.dastan.tests;

import com.dastan.driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTests extends BaseTest {

    //1. Never hardcode
    private LoginPageTests() {
    }



    @Test
    public void test2() {

       DriverManager.getDriver().findElement(By.name("q")).sendKeys("Iphone", Keys.ENTER);



    }




}
