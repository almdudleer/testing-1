package com.almdudleer.labs.testing.lab3.tests.profile;

import com.almdudleer.labs.testing.lab3.pages.profile.PersonalInfoPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import com.almdudleer.labs.testing.lab3.utils.Elements;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
        String newLastName = common.appUtils.changeString(page.getFirstName());
        page.enterLastName(newLastName);
        assertTrue(page.saveChanges());
    }

    @Test
    public void updateZipCode() {
        String newZipCode = common.appUtils.changeString(page.getFirstName());
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

    @Test
    public void alertCloseBtn() {
        updateFirstName();
        assertEquals("Everything was saved successfully!", common.utils.getClickableElement(Elements.alertSpan).getText());
        common.utils.clickElement(Elements.alertBtn);
        common.utils.wait.until(ExpectedConditions.invisibilityOfElementLocated(Elements.alertSpan));
    }

    @Test
    public void alertDisappearTimeout() {
        updateFirstName();
        common.utils.wait.until(ExpectedConditions.visibilityOfElementLocated(Elements.alertSpan));
        common.utils.wait.until(ExpectedConditions.invisibilityOfElementLocated(Elements.alertSpan));
    }

    @Test
    public void emailWithSpace() {
        page.enterEmail("asd fgh@nail.ru");
        page.saveChanges();
        assertEquals("Email is not valid.", common.utils.getClickableElement(Elements.alertSpan).getText());
        common.utils.clickElement(Elements.alertBtn);
    }

    @Test
    public void emailWithoutAt() {
        page.enterEmail("asdfghnail.ru");
        page.saveChanges();
        assertEquals("Email is not valid.", common.utils.getClickableElement(Elements.alertSpan).getText());
        common.utils.clickElement(Elements.alertBtn);
    }

}
