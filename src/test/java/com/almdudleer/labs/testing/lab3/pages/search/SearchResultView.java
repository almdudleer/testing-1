package com.almdudleer.labs.testing.lab3.pages.search;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class SearchResultView extends Page {
    By nextImageArrow = By.xpath(
            "/html/body/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/div/div");
    By prevImageArrow = By.xpath(
            "/html/body/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/div/div");
    By backArrow = By.xpath(
            "//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[1]/button");

    public SearchResultView(SeleniumUtils utils) {
        super(utils);
        URL = null;
        anchor = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[2]/aside");
    }

    public void nextImage() {
        utils.clickElement(nextImageArrow);
    }

    public void previousImage() {
        utils.clickElement(prevImageArrow);
    }

    public void selectImagePreview(int num) {
        By imagePreview = By.xpath(
                "//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[" + num + "]");
        utils.clickElement(imagePreview);
    }

    @Override
    public void go() {
        throw new UnsupportedOperationException("Not supported");
    }

    public void backToResults() {
        utils.clickElement(backArrow);
    }
}
