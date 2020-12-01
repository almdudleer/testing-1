package com.almdudleer.labs.testing.lab3.pages.search;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class SearchResultView extends Page {
    private final By res;
    By nextImageArrow = By.cssSelector(
            "#overflow-container > div.search-fullscreen-container > div > div > div.Wrapper-sc-sb47ut.jOZgfj > div.Container-sc-1fur91q.cmOOIr > div.Content-sc-tyw62k.dxGOIS > div.ImageContent-sc-1qcgksm.dVxqGv > div.full-screen-image > div.Link-sc-1allwjb.gDNrnT > div.full-screen-image-arrow-right > div > div");
    By prevImageArrow = By.cssSelector(
            "#overflow-container > div.search-fullscreen-container > div > div > div.Wrapper-sc-sb47ut.jOZgfj > div.Container-sc-1fur91q.cmOOIr > div.Content-sc-tyw62k.dxGOIS > div.ImageContent-sc-1qcgksm.dVxqGv > div.full-screen-image > div.Link-sc-1allwjb.gDNrnT > div.full-screen-image-arrow-left > div > div");
    By backArrow = By.cssSelector(
            "#overflow-container > div.search-fullscreen-container > div > div > div.Wrapper-sc-sb47ut.jOZgfj > div.Container-sc-1fur91q.cmOOIr > div.Content-sc-tyw62k.dxGOIS > div.full-screen-back-btn > button");

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
        By imagePreview = By.cssSelector(
                "#overflow-container > div.Container-sc-1i775g0.fpnMhK > div.Search-sc-p6ea0f.goWqfR > div > div > div:nth-child(2) > div:nth-child(" + 3 + ") > div");
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
