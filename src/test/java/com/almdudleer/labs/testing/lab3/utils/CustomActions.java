package com.almdudleer.labs.testing.lab3.utils;

import com.almdudleer.labs.testing.lab3.pages.LoginPage;
import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.pages.profile.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class CustomActions {
    private final SeleniumUtils utils;
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

    public void scrollToElement(By by) {
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = utils.driver.findElement(by);
        Actions actions = new Actions(utils.driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
