package com.dastan.pages;

import com.dastan.enums.WaitStrategy;
import com.dastan.utilities.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class AmazonHamburgerMenuPage extends BasePage{


    private String linkCOmputer = "//div[text()='Computers']/parent::a";

    private String linkSubMenu = "//a[text()='%s']";
    public AmazonHamburgerMenuPage clickComputer() throws InterruptedException {
        click(By.xpath(linkCOmputer),WaitStrategy.CLICKABLE,"Computers");
//        Thread.sleep(3000);
        return this;
    }

    public AmazonMonitorsPage clickOnSubMenuItem(String menuText){
        String newxpath = DynamicXpathUtils.getXpath(linkSubMenu,menuText);
        click(By.xpath(newxpath), WaitStrategy.VISIBILITY,"menuText");

        if(menuText.contains("Monitors")){
            return new AmazonMonitorsPage();
        }
        return null;
    }


}
