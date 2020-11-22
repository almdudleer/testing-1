package com.almdudleer.labs.testing.lab3.utils;

public class Storage {
    private final SeleniumUtils utils;

    public Storage(SeleniumUtils utils) {
        this.utils = utils;
    }

    public boolean isLoggedIn() {
        return !utils.driver.manage().getCookies().isEmpty() && utils.driver.manage()
                .getCookieNamed("app_auth") != null;
    }
}
