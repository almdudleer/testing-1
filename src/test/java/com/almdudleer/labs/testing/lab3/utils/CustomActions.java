package com.almdudleer.labs.testing.lab3.utils;

import com.almdudleer.labs.testing.lab3.pages.LoginPage;
import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.pages.profile.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class CustomActions {
    public final SeleniumUtils utils;
    private final Storage storage;

    public CustomActions(SeleniumUtils utils, Storage storage) {
        this.utils = utils;
        this.storage = storage;
    }

    public void logInCorrect() {
        if (!storage.isLoggedIn()) {
            LoginPage loginPage = new LoginPage(utils);
            loginPage.go();
            loginPage.logIn("prettyfrog", "qwerty123");
            utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
            utils.clickElement(Page.acceptCookieBtn);
        }
    }

    public void logOut() {
        if (storage.isLoggedIn()) {
            ProfilePage profilePage = new ProfilePage(utils);
            profilePage.go();
            utils.driver.findElement(avatar).click();
            utils.driver.findElement(By.linkText("Log Out")).click();
        }
    }

}
