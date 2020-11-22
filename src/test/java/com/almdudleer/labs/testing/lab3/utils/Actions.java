package com.almdudleer.labs.testing.lab3.utils;

import com.almdudleer.labs.testing.lab3.pages.AccountPage;
import com.almdudleer.labs.testing.lab3.pages.LoginPage;
import org.openqa.selenium.By;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class Actions {
    private final SeleniumUtils utils;
    private final Storage storage;

    public Actions(SeleniumUtils utils, Storage storage) {
        this.utils = utils;
        this.storage = storage;
    }

    public void logInCorrect() {
        if (!storage.isLoggedIn()) {
            LoginPage loginPage = new LoginPage(utils);
            loginPage.go();
            loginPage.logIn("prettyfrog", "qwerty123");

        }
    }

    public void logOut() {
        if (storage.isLoggedIn()) {
            AccountPage accountPage = new AccountPage(utils);
            accountPage.go();
            utils.driver.findElement(avatar).click();
            utils.driver.findElement(By.linkText("Log Out")).click();
        }
    }
}
