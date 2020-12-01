package com.almdudleer.labs.testing.lab3.utils;

/**
 * Just an easy builder and access point (facade) for utils, actions and storage to be used in tests only.
 * TODO: Think of a better name
 */
public class Common {
    public SeleniumUtils utils;
    public AppUtils appUtils;

    public Common() {
        utils = new SeleniumUtils();
        appUtils = new AppUtils(utils);
    }

    public void tearDown() {
        utils.driver.quit();
    }
}
