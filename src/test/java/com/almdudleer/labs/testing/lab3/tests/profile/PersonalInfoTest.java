package com.almdudleer.labs.testing.lab3.tests.profile;

import com.almdudleer.labs.testing.lab3.pages.profile.PersonalInfoPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import com.almdudleer.labs.testing.lab3.utils.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class PersonalInfoTest {
    Common common;
    PersonalInfoPage page;

    @Before
    public void setUp() {
        common = new Common();
        common.appUtils.logInCorrect();
        page = new PersonalInfoPage(common.utils);
        page.go();
    }

    @After
    public void tearDown() {
        common.utils.driver.quit();
    }

    @Test
    public void updateFirstName() {
        String newFirstName = nextChar(page.getFirstName().charAt(0)) + page.getFirstName().substring(1);
        page.enterFirstName(newFirstName);
        assertTrue(page.saveChanges());
    }

    @Test
    public void updateLastName() {
        String newLastName = nextChar(page.getLastName().charAt(0)) + page.getLastName().substring(1);
        page.enterLastName(newLastName);
        assertTrue(page.saveChanges());
    }

    @Test
    public void updateZipCode() {
        String newZipCode = nextChar(page.getZipCode().charAt(0)) + page.getZipCode().substring(1);
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

    public char nextChar(char character) {
        if (character >= 'A' && character <= 'z')
            return (char) (character != 'z' ? character + 1 : 'A');
        else if (character >= '0' && character <= '9')
            return (char) (character != '9' ? character + 1 : '0');
        else return '0';
    }
}
