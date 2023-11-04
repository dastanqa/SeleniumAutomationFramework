package com.dastan.pages;

import com.dastan.enums.WaitStrategy;
import org.openqa.selenium.By;

public class OrangeHRMHomePage extends BasePage {

    private final By profPic = By.xpath("//img[@alt='profile picture' and @class='oxd-userdropdown-img']");
    private final By linkLogout = By.xpath("//a[text()='Logout']");

    public OrangeHRMHomePage clickProfile() {


        click(profPic,WaitStrategy.CLICKABLE,"Profile picture");



        return this;
    }

    public OrangeHRMLoginPage clickLogout() {
        click(linkLogout, WaitStrategy.CLICKABLE,"Logout button");

        return new OrangeHRMLoginPage();
    }

}
