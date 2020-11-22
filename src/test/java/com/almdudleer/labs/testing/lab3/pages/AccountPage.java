package com.almdudleer.labs.testing.lab3.pages;

import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;

public class AccountPage extends Page {
    public AccountPage(SeleniumUtils utils) {
        super(utils);
        URL = "https://app.photobucket.com/profile/account";
    }
}
