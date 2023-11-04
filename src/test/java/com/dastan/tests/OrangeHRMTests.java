package com.dastan.tests;

import com.dastan.listeners.RetryFailedTests;
import com.dastan.pages.OrangeHRMLoginPage;
import com.dastan.utilities.DataProviderUtils;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMTests extends BaseTest {
    private OrangeHRMTests() {

    }


    @Test
    public void loginLogoutTest(Map<String, String> data) throws InterruptedException {
        Thread.sleep(3000);


        String title = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfile().clickLogout()
                .title();

        System.out.println(title);
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    public void newTest(Map<String, String> data) throws InterruptedException {
        Thread.sleep(3000);


        String title = new OrangeHRMLoginPage()
                .enterUsername(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickProfile().clickLogout()
                .title();

        System.out.println(title);
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }


}
