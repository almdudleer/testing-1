package com.almdudleer.labs.testing.lab3.utils;

import com.almdudleer.labs.testing.lab3.pages.LoginPage;
import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.pages.profile.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class AppUtils {
    public final SeleniumUtils utils;

    public AppUtils(SeleniumUtils utils) {
        this.utils = utils;
    }

    public void logInCorrect() {
        if (!isLoggedIn()) {
            LoginPage loginPage = new LoginPage(utils);
            loginPage.go();
            loginPage.logIn("prettyfrog", "qwerty123");
            utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
            utils.clickElement(Page.acceptCookieBtn);
        }
    }

    public void logOut() {
        if (isLoggedIn()) {
            ProfilePage profilePage = new ProfilePage(utils);
            profilePage.go();
            utils.driver.findElement(avatar).click();
            utils.driver.findElement(By.linkText("Log Out")).click();
        }
    }

    public boolean isLoggedIn() {
        return !utils.driver.manage().getCookies().isEmpty() && utils.driver.manage()
                .getCookieNamed("app_auth") != null;
    }

}
