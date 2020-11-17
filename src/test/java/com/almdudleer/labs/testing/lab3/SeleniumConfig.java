package com.almdudleer.labs.testing.lab3;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SeleniumConfig {

    private WebDriver driver;

    public SeleniumConfig() {
        Capabilities capabilities = DesiredCapabilities.firefox();
        driver = new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    static {
        System.setProperty("webdriver.gecko.driver", findDriver());
    }

    static private String findDriver() {
        String[] paths = {"", "bin/", "target/classes"};
        for (String path : paths) {
            if (new File(path + "geckodriver.mac").exists())
                return path + "geckodriver.mac";
        }
        return "";
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
