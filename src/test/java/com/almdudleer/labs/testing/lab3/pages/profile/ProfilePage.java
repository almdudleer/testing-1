package com.almdudleer.labs.testing.lab3.pages.profile;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;

public class ProfilePage extends Page {
    public ProfilePage(SeleniumUtils utils) {
        super(utils);
        Url = "https://app.photobucket.com/profile/account";
    }
}
