package com.almdudleer.labs.testing.lab3.utils;

import com.almdudleer.labs.testing.lab3.pages.auth.LoginPage;
import com.almdudleer.labs.testing.lab3.pages.profile.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class AppUtils {
    public final SeleniumUtils utils;

    public final String LOGIN = "prettyfrog";
    public final String PASSWORD = "qwerty123";

    public AppUtils(SeleniumUtils utils) {
        this.utils = utils;
    }

    public void logInCorrect() {
        if (!isLoggedIn()) {
            LoginPage loginPage = new LoginPage(utils);
            loginPage.go();
            loginPage.logIn(LOGIN, PASSWORD);
            utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
            acceptCookies();
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

    public void acceptCookies() {
        utils.clickElement(Elements.acceptCookieBtn);
    }

    public String getAlertText() {
        return utils.getClickableElement(Elements.alertSpan).getText();
    }

    public String changeString(String s) {
        return nextChar(s.charAt(0)) + s.substring(1);
    }

    public char nextChar(char character) {
        if (character >= 'A' && character <= 'z')
            return (char) (character != 'z' ? character + 1 : 'A');
        else if (character >= '0' && character <= '9')
            return (char) (character != '9' ? character + 1 : '0');
        else return '0';
    }
}
