package com.almdudleer.labs.testing.lab3.tests.profile;

import com.almdudleer.labs.testing.lab3.pages.profile.SecurityPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecurityPageTest {
    Common common;
    SecurityPage page;

    @BeforeEach
    public void setUp() {
        common = new Common();
        common.appUtils.logInCorrect();
        page = new SecurityPage(common.utils);
        page.go();
    }

    @AfterEach
    public void tearDown() {
        common.tearDown();
    }

    @Test
    public void testIncorrectPassword() {
        String incorrectPassword = common.appUtils.changeString(common.appUtils.PASSWORD);
        page.enterPassword(incorrectPassword);
        page.enterNewPassword(incorrectPassword);
        page.enterPasswordConfirmation(incorrectPassword);
        page.saveChanges();
        assertEquals("Failed to update password. Please, try again later.", common.appUtils.getAlertText());
    }

    @Test
    public void testNonMatchingPasswords() {
        String incorrectPassword = common.appUtils.changeString(common.appUtils.PASSWORD);
        page.enterPassword(common.appUtils.PASSWORD);
        page.enterNewPassword(incorrectPassword);
        page.enterPasswordConfirmation(common.appUtils.changeString(incorrectPassword));
        page.saveChanges();
        assertEquals("Failed to update password. Please, try again later.", common.appUtils.getAlertText());
    }
}
