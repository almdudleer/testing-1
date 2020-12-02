package com.almdudleer.labs.testing.lab3.pages.auth;

import com.almdudleer.labs.testing.lab3.pages.ExplorePage;
import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.openqa.selenium.By;

public class SignUpPage extends Page {
    By emailForm = By.xpath("//*[@id=\"signup-email\"]");
    By emailHint = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[3]/form/div[1]/div[1]/div[2]");

    By usernameForm = By.xpath("//*[@id=\"signup-username\"]");
    By usernameHint = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[3]/form/div[1]/div[2]/div[2]");

    public By passwordForm = By.xpath("//*[@id=\"signup-password\"]");
    By passwordEye = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[3]/form/div[1]/div[3]/div/div/svg");
    By passwordHint = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[3]/form/div[1]/div[3]/div[2]");

    By iAm16 = By.xpath("//*[@id=\"userAgreement\"]");
    By iAm16Hint = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[3]/form/div[2]/div");

    By createAccBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[3]/div[3]/button");

    public SignUpPage(Common common) {
        super(common);
        anchor = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[3]/div[2]");
    }

    @Override
    public void go() {
        ExplorePage explorePage = new ExplorePage(utils);
        explorePage.go();
        common.appUtils.acceptCookies();
        explorePage.toSignupPage();
        utils.clickElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/div/div[3]/div[4]/button"));
        utils.clickElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/button[1]"));
        waitOpen();
    }

    public void enterEmail(String email) {
        utils.getClickableElement(emailForm).sendKeys(email);
    }

    public void enterUsername(String username) {
        utils.getClickableElement(usernameForm).sendKeys(username);
    }

    public void enterPassword(String password) {
        utils.getClickableElement(passwordForm).sendKeys(password);
    }

    public void switchSeePassword() {
        utils.clickElement(passwordEye);
    }

    public void switchIAm16() {
        utils.clickElement(iAm16);
    }

    public void pressCreateAcc() {
        utils.clickElement(createAccBtn);
    }

    public String getEmailHint() {
        return utils.getClickableElement(emailHint).getText();
    }

    public String getUsernameHint() {
        return utils.getClickableElement(usernameHint).getText();
    }

    public String getPasswordHint() {
        return utils.getClickableElement(passwordHint).getText();
    }

    public String getIAm16Hint() {
        return utils.getClickableElement(iAm16Hint).getText();
    }
}
