package com.almdudleer.labs.testing.lab3.tests.search;

import com.almdudleer.labs.testing.lab3.pages.search.SearchPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchTest {
    Common common;
    List<WebElement> foundElements;

    @BeforeEach
    public void setUp() {
        common = new Common();
        common.customActions.logInCorrect();
        SearchPage searchPage = new SearchPage(common.utils);
        searchPage.go();
        foundElements = searchPage.search("frog");
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(foundElements.get(3)));
    }

    @AfterEach
    public void tearDown() {
        common.tearDown();
    }

    @Test
    void findFrogImage() {
        foundElements.get(3).click();
        common.utils.wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]")));

    }


}
