package com.almdudleer.labs.testing.lab3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccountTest {
    private WebDriver driver;
    Utils utils;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        utils = new Utils(driver);
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
