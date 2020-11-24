package com.almdudleer.labs.testing.lab3.pages;

import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class Page {
    public SeleniumUtils utils;
    public static String URL;
    public static By anchor;

    // TODO: think of a better way of managing utils
    public Page(SeleniumUtils utils) {
        this.utils = utils;
    }

    public void go() {
        this.utils.driver.get(URL);
        waitOpen();
    }

    public void waitOpen() {
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(anchor));
    }

}
