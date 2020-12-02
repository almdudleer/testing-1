package com.almdudleer.labs.testing.lab3.tests.profile;

import com.almdudleer.labs.testing.lab3.pages.profile.PersonalInfoPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import com.almdudleer.labs.testing.lab3.utils.Elements;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalInfoTest {
    Common common;
    PersonalInfoPage page;

    @BeforeEach
    public void setUp() {
        common = new Common();
        common.appUtils.logInCorrect();
        page = new PersonalInfoPage(common.utils);
        page.go();
    }

    @AfterEach
    public void tearDown() {
        common.tearDown();
    }

    @Test
    public void updateFirstName() {
        String newFirstName = common.appUtils.changeString(page.getFirstName());
        page.enterFirstName(newFirstName);
        assertTrue(page.saveChanges());
    }

    @Test
    public void updateLastName() {
        String newLastName = common.appUtils.changeString(page.getLastName());
        page.enterLastName(newLastName);
        assertTrue(page.saveChanges());
    }

    @Test
    public void updateZipCode() {
        String newZipCode = common.appUtils.changeString(page.getZipCode());
        page.enterZipCode(newZipCode);
        assertTrue(page.saveChanges());
    }

    @Test
    public void switchBirthDate() {
        page.switchBirthDate();
        assertTrue(page.saveChanges());
    }

    @Test
    public void switchLocation() {
        page.switchLocation();
        assertTrue(page.saveChanges());
    }

    @Test
    public void noChanges() {
        assertFalse(page.saveChanges());
    }

    @ParameterizedTest
    @ValueSource(strings = {"vincentd0jriversm.com", "vincentd0@jriversm", "vincentd0@jriversad,casd.com", "vin centd0@jriversadcasd.com"})
    public void invalidEmail(String email) {
        page.enterEmail(email);
        page.saveChanges();
        assertEquals("Email is not valid.", common.appUtils.getAlertText());
    }

    // Alert tests
    @Test
    public void alertCloseBtn() {
        updateFirstName();
        assertEquals("Everything was saved successfully!", common.appUtils.getAlertText());
        common.utils.clickElement(Elements.alertBtn);
        common.utils.wait.until(ExpectedConditions.invisibilityOfElementLocated(Elements.alertSpan));
    }

    @Test
    public void alertDisappearTimeout() {
        updateFirstName();
        common.utils.wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.alertSpan));
        common.utils.wait.until(ExpectedConditions.invisibilityOfElementLocated(Elements.alertSpan));
    }

}
