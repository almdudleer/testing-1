package com.almdudleer.labs.testing.lab3.pages;

import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;

public class ExplorePage extends Page {
    public static final By logInBtn = By.linkText("Log In");
    public static final By signUpBtn = By.linkText("Sign Up");

    public ExplorePage(SeleniumUtils utils) {
        super(utils);
        URL = "https://app.photobucket.com/explore";
        anchor = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[1]/div[1]");
    }

    public void toLoginPage() {
        utils.driver.findElement(logInBtn).click();
    }

    public void toSignupPage() {
        utils.driver.findElement(signUpBtn).click();
    }
}
