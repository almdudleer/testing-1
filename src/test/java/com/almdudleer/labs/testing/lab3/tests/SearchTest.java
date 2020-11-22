package com.almdudleer.labs.testing.lab3.tests;

import com.almdudleer.labs.testing.lab3.pages.SearchPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTest {
    Common common;

    @BeforeEach
    public void setUp() {
        common = new Common();
        common.actions.logInCorrect();
    }

    @AfterEach
    public void tearDown() {
        common.tearDown();
    }

    @Test
    void findFrogImage() {
        SearchPage searchPage = new SearchPage(common.utils);
        List<WebElement> foundElements = searchPage.search("frog");
        foundElements.get(3).click();
    }
}
