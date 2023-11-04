package com.dastan.pages;

import com.dastan.driver.DriverManager;
import com.dastan.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    /*
    id
    name
    classname
    linktext
    partiallinktext
    xpath
     */
    //Assertions should not be called in page layers
    //All your page methods needs to have some return type
    public final By txtboxUsername = By.name("username");
    public final By txtboxPassword = By.xpath("//input[@name='password' and @type='password']");
    public final By loginBtn = By.xpath("//button[@type='submit']");

    public OrangeHRMLoginPage enterUsername(String username) {
        sendKeys(txtboxUsername, username, WaitStrategy.PRESENCE, "username input");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {

        sendKeys(txtboxPassword, password, WaitStrategy.PRESENCE, "password input");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(loginBtn, WaitStrategy.NONE, "Login button");
        return new OrangeHRMHomePage();
    }

    public String title() {
        return getTitle();
    }
}
