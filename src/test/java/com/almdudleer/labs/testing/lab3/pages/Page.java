package com.almdudleer.labs.testing.lab3.pages;

import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;

public abstract class Page {
    public SeleniumUtils utils;
    public static String URL;

    // TODO: think of a better way of managing utils
    public Page(SeleniumUtils utils) {
        this.utils = utils;
    }

    public void go() {
        this.utils.driver.get(URL);
    }

}
