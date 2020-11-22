package com.almdudleer.labs.testing.lab3.pages;

import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class LoginPage extends Page {
    By loginField = By.id("login-loginfield");
    By passField = By.id("login-pass");
    By logInBtn = By.cssSelector(".Button-sc-1mhdsiq");

    public LoginPage(SeleniumUtils utils) {
        super(utils);
        URL = "https://app.photobucket.com/login";
    }

    public void logIn(String login, String password)  {
        utils.driver.findElement(loginField).sendKeys(login);
        utils.driver.findElement(passField).sendKeys(password);
        utils.driver.findElement(logInBtn).click();
        utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
    }
}
