package com.almdudleer.labs.testing.lab3.pages;

import com.almdudleer.labs.testing.lab3.utils.Common;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class Page {
    public SeleniumUtils utils;
    public Common common;
    public String Url;
    public By anchor;

    // TODO: think of a better way of managing utils
    public Page(SeleniumUtils utils) {
        this.utils = utils;
    }

    public Page(Common common) {
        this.common = common;
        this.utils = common.utils;
    }

    public void go() {
        this.utils.driver.get(Url);
        waitOpen();
    }

    public void waitOpen() {
        if (anchor != null)
            utils.wait.until(ExpectedConditions.presenceOfElementLocated(anchor));
    }

}
