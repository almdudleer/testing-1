package com.almdudleer.labs.testing.lab3.tests;

import com.almdudleer.labs.testing.lab3.pages.ExplorePage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class AuthTest {
    Common common;

    @Before
    public void setUp() {
        common = new Common();
    }

    @After
    public void tearDown() {
        common.utils.driver.quit();
    }

    @Test
    public void logInTestCookie() {
        common.appUtils.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        Assert.assertTrue(common.appUtils.isLoggedIn());
    }

    @Test
    public void logInTestAvatar() {
        common.appUtils.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        Assert.assertTrue(common.utils.elementExists(avatar));
    }

    @Test
    public void logOutTestCookie() {
        common.appUtils.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        common.appUtils.logOut();
        Assert.assertFalse(common.appUtils.isLoggedIn());
    }

    @Test
    public void logOutTestButtons() {
        common.appUtils.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        common.appUtils.logOut();

        ExplorePage explorePage = new ExplorePage(common);
        explorePage.go();

        Assert.assertTrue(common.utils.elementExists(ExplorePage.logInBtn));
        Assert.assertTrue(common.utils.elementExists(ExplorePage.signUpBtn));
    }
}
