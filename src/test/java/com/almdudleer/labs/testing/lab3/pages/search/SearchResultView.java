package com.almdudleer.labs.testing.lab3.pages.search;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class SearchResultView extends Page {
    private final By res;
    By nextImageArrow = By.xpath(
            "//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/div/div/svg");
    By prevImageArrow = By.xpath(
            "//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div/div/svg");
    By backArrow = By.xpath(
            "//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[1]/button/div");

    public SearchResultView(SeleniumUtils utils, By res) {
        super(utils);
        Url = null;
        anchor = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[2]/aside");
        this.res = res;
    }

    public void nextImage() {
        utils.clickElement(nextImageArrow);
    }

    public void previousImage() {
        utils.clickElement(prevImageArrow);
    }

    public void selectImagePreview(int num) {
        By imagePreview = By.xpath(
                "//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[" + num + "]/img");
        utils.clickElement(imagePreview);
    }

    @Override
    public void go() {
        utils.clickElement(res);
        waitOpen();
    }

    public void backToResults() {
        utils.clickElement(backArrow);
    }
}
