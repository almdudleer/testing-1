package com.almdudleer.labs.testing.lab3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AccountTest {
    private WebDriver driver;
    Utils utils;

    @Before
    public void setUp() {
        utils = new Utils();
        this.driver = utils.getDriver();
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
