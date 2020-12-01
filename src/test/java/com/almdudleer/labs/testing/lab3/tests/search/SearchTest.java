package com.almdudleer.labs.testing.lab3.tests.search;

import com.almdudleer.labs.testing.lab3.pages.search.SearchPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchTest {
    Common common;
    SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        common = new Common();
        common.appUtils.logInCorrect();
        searchPage = new SearchPage(common.utils);
        searchPage.go();
        searchPage.search("frog");
    }

    @AfterEach
    public void tearDown() {
        common.tearDown();
    }

    @Test
    void findFrogImage() {
        searchPage.openSearchResult(3);
    }

    @Test
    void yourBucketToggle() {
        searchPage.selectYourBucketToggle();
        common.utils.wait.until(ExpectedConditions.textToBe(searchPage.searchTitle, "No search results for “frog”"));
    }

    @Test
    void allCommunityToggle() {
        searchPage.selectYourBucketToggle();
        searchPage.selectAllCommunityToggle();
        common.utils.wait.until(ExpectedConditions.textToBe(searchPage.searchTitle, "Search results for “frog”"));
    }
}
