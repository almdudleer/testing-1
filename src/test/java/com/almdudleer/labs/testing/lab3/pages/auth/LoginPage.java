package com.almdudleer.labs.testing.lab3.pages.auth;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class LoginPage extends Page {
    By loginField = By.id("login-loginfield");
    By passField = By.id("login-pass");
    By signInBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/form/div[3]/button");

    public LoginPage(SeleniumUtils utils) {
        super(utils);
        Url = "https://app.photobucket.com/login";
        anchor = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[1]");
    }

    public void logIn(String login, String password)  {
        utils.driver.findElement(loginField).sendKeys(login);
        utils.driver.findElement(passField).sendKeys(password);
        utils.clickElement(signInBtn);
    }
}
