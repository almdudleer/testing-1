package com.almdudleer.labs.testing.lab3.pages.search;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ImageView extends Page {
    SearchPage searchPage;
    public ImageView(SeleniumUtils utils) {
        super(utils);
        searchPage = new SearchPage(utils);
    }

    @Override
    public void go() {
        searchPage.go();
        List<WebElement> results = searchPage.search("frog");
        utils.wait.until(ExpectedConditions.elementToBeClickable(results.get(3)));
        results.get(3).click();
    }
}
