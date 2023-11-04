package com.dastan.driver;

import com.dastan.constants.FrameworkConstants;
import com.dastan.enums.ConfigProperties;
import com.dastan.utilities.JsonUtils;
import com.dastan.utilities.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

public final class Driver {

    private Driver(){}






    public static void initDriver(String browser) throws Exception {

        if (Objects.isNull(DriverManager.getDriver())) {

            if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
            DriverManager.setDriver(new ChromeDriver());

            } else if (browser.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver",FrameworkConstants.getGeckodriver());
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
                DriverManager.setDriver(new FirefoxDriver(options));
            }
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {

        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
