package com.almdudleer.labs.testing.lab3.tests;

import com.almdudleer.labs.testing.lab3.pages.ExplorePage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class AccountTest {
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
        common.actions.logInCorrect();
        Assert.assertTrue(common.storage.isLoggedIn());
    }

    @Test
    public void logInTestAvatar() {
        common.actions.logInCorrect();
        Assert.assertTrue(common.utils.elementExists(avatar));
    }

    @Test
    public void logOutTestCookie() {
        common.actions.logInCorrect();
        common.actions.logOut();
        Assert.assertFalse(common.storage.isLoggedIn());
    }

    @Test
    public void logOutTestButtons() {
        common.actions.logInCorrect();
        common.actions.logOut();

        ExplorePage explorePage = new ExplorePage(common.utils);
        explorePage.go();

        Assert.assertTrue(common.utils.elementExists(ExplorePage.logInBtn));
        Assert.assertTrue(common.utils.elementExists(ExplorePage.signUpBtn));
    }
}
