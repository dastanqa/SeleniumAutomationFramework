package com.dastan.tests;

import com.dastan.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class HomePageTests extends BaseTest {

    private HomePageTests() {
    }


    @Test
    public void test2() {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing mini bytes - youtube", Keys.ENTER);
        String title = DriverManager.getDriver().getTitle();

        assertThat(title)
                .as("Object is actually null").isNotNull()
                .as("It does not contain expected text").containsIgnoringCase("Google Издөө")
                .as("It does not match expected pattern").matches("\\w.*"+"Google Издөө")
                                                .hasSizeBetween(15,100);

//        Assert.assertTrue(Objects.nonNull(title));
//
//        Assert.assertTrue(title.contains("Google Издөө"));
//        Assert.assertTrue(title.matches("\\w.*"+"Google Издөө"));
//        Assert.assertTrue(title.length()>15);
//        Assert.assertTrue(title.length()<100);

        List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//h3"));
        assertThat(elements)
                        .hasSizeBetween(9,11)
                                .extracting(WebElement::getText)
                                        .contains("Google Издөө");

//        Assert.assertEquals(elements.size(),11);
//
//        boolean isElementPresent = false;
//
//        for (WebElement element:elements)
//        {
//            if(element.getText().equalsIgnoreCase("testing mini bytes - youtube")){
//                isElementPresent = true;
//                break;
//            }
//        }

//        Assert.assertTrue(isElementPresent,"Test Mini Bytes Not Found!");
    }
}
