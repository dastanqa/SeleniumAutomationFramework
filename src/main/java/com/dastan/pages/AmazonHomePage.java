package com.dastan.pages;

import com.dastan.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class AmazonHomePage extends BasePage{

    @FindBy(id = "nav-hamburger-menu")
    private WebElement linkHamburder;

    public AmazonHomePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public AmazonHamburgerMenuPage clickHamburger(){
        linkHamburder.click();
        return new AmazonHamburgerMenuPage();
    }


}
