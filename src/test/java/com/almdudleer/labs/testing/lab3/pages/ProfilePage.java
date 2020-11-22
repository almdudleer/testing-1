package com.almdudleer.labs.testing.lab3.pages;

import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;

public class ProfilePage extends Page {
    public ProfilePage(SeleniumUtils utils) {
        super(utils);
        URL = "https://app.photobucket.com/profile/account";
    }
}
