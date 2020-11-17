package com.almdudleer.labs.testing.lab3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AccountTest {
    private WebDriver driver;
    WebDriverWait wait;
    Utils utils;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        utils = new Utils(driver, wait);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void logInTest() {
        utils.logIn();
        Assert.assertNotEquals(driver.findElement(Utils.avatar), null);
    }

    @Test
    public void logOutTest() {
        utils.logIn();
        utils.logOut();
        Assert.assertNotEquals(driver.findElement(Utils.logInBtn), null);
        Assert.assertNotEquals(driver.findElement(Utils.signUpBtn), null);
    }
}
