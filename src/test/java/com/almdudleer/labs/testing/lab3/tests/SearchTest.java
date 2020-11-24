package com.almdudleer.labs.testing.lab3.tests;

import com.almdudleer.labs.testing.lab3.pages.search.ImageView;
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
        searchPage.go();
        List<WebElement> foundElements = searchPage.search("frog");
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(foundElements.get(3)));
        foundElements.get(3).click();
        common.utils.wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/img")));
    }

    @Test
    void selectNextImage() {
        ImageView view = new ImageView(common.utils);
        view.go();
        WebElement nextImage = common.utils.driver.findElement(By
                .xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[4]/img"));
        nextImage.click();
    }
}
