package com.almdudleer.labs.testing.lab3.utils;

/**
 * Just an easy builder and access point (facade) for utils, actions and storage to be used in tests only.
 * TODO: Think of a better name
 */
public class Common {
    public SeleniumUtils utils;
    public CustomActions customActions;
    public Storage storage;

    public Common() {
        utils = new SeleniumUtils();

        // We may combine the following classes:
        storage = new Storage(utils);
        customActions = new CustomActions(utils, storage);
    }

    public void tearDown() {
        utils.driver.quit();
    }
}
