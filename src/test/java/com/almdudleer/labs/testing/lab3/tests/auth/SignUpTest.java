package com.almdudleer.labs.testing.lab3.tests.auth;

import com.almdudleer.labs.testing.lab3.pages.auth.SignUpPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignUpTest {
    Common common;
    SignUpPage page;

    @BeforeEach
    void setUp() {
        common = new Common();
        page = new SignUpPage(common);
        page.go();
    }

    @AfterEach
    public void tearDown() {
        common.tearDown();
    }

    @Test
    public void testValidDestination() {
        assertEquals("Create your account", common.utils.getClickableElement(page.anchor).getText());
    }

    // Test existing credentials validation
    @Test
    public void existingLogin() {
        page.enterUsername(common.appUtils.LOGIN);
        page.pressCreateAcc();
        assertEquals("This username is already registered", page.getUsernameHint());
    }

    @Test
    public void existingEmail() {
        page.enterEmail("vincentd0@jriversm.com");
        page.pressCreateAcc();
        assertEquals("This email is already registered", page.getEmailHint());
    }

    // Test required fields validation
    @Test
    public void emptyLogin() {
        page.pressCreateAcc();
        assertEquals("Required field", page.getUsernameHint());
    }

    @Test
    public void emptyEmail() {
        page.pressCreateAcc();
        assertEquals("Required field", page.getEmailHint());
    }

    @Test
    public void emptyPassword() {
        page.pressCreateAcc();
        assertEquals("Required field", page.getPasswordHint());
    }

    @Test
    public void empty16yo() {
        page.pressCreateAcc();
        assertEquals("Required field", page.getIAm16Hint());
    }

    // Test constraints
    @Test
    public void testPasswordLength() {
        page.enterPassword("1234");
        page.pressCreateAcc();
        assertEquals("Password should be at least 6 characters", page.getPasswordHint());
    }

    @ParameterizedTest
    @ValueSource(strings = {"vincentd0jriversm.com", "vincentd0@jriversm", "vincentd0@jriversad,casd.com", "vin centd0@jriversadcasd.com"})
    public void testInvalidEmail(String email) {
        page.enterEmail(email);
        page.pressCreateAcc();
        assertEquals("Email should have valid format", page.getEmailHint());
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "asdfasdfasdfasdfasdfasdfasdfasdfa", "129()e1e,dd"})
    public void testInvalidUsername(String username) {
        page.enterUsername(username);
        page.pressCreateAcc();
        assertEquals(
                "Username should be from 4 to 32 characters long, and use only letters, numbers and \"_\"",
                page.getUsernameHint()
        );
    }

    // Other
    @Test
    @Disabled
    public void testPasswordVisibility() {
        page.enterPassword("1234");
        assertEquals("password", common.utils.getClickableElement(page.passwordForm).getAttribute("type"));
        page.switchSeePassword();
        assertEquals("text", common.utils.getClickableElement(page.passwordForm).getAttribute("type"));
        page.switchSeePassword();
        assertEquals("password", common.utils.getClickableElement(page.passwordForm).getAttribute("type"));
    }
}
