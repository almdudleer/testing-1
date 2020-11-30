package com.almdudleer.labs.testing.lab3.tests.search;

import com.almdudleer.labs.testing.lab3.pages.search.SearchPage;
import com.almdudleer.labs.testing.lab3.pages.search.SearchResultView;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultViewTest {
    Common common;
    SearchResultView searchResultView;

    @BeforeEach
    public void setUp() {
        common = new Common();
        common.customActions.logInCorrect();
        SearchPage searchPage = new SearchPage(common.utils);
        searchPage.go();
        List<WebElement> foundElements = searchPage.search("frog");
        searchResultView = searchPage.openSearchResult(foundElements, 3);
    }

    @AfterEach
    public void tearDown() {
        common.tearDown();
    }

    @Test
    void selectNextImageArrow() {
        searchResultView.nextImage();
    }

    @Test
    void selectPreviousImageArrow() {
        searchResultView.previousImage();
    }

    @Test
    void selectNextImagePreview() {
        searchResultView.selectImagePreview(4);
    }

    @Test
    void backToResults() {
        searchResultView.backToResults();
    }
}

