package com.dastan.tests;

import com.dastan.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class AmazonDemoTest extends BaseTest{
    private AmazonDemoTest(){
    }


    @Test
    public void amazonTest(Map<String,String>data) throws InterruptedException {
        String title= new AmazonHomePage().clickHamburger().clickComputer()
                .clickOnSubMenuItem(data.get("menutext")).getTitle();

        Assertions.assertThat(title).isNotNull().isNotBlank();
    }
}
