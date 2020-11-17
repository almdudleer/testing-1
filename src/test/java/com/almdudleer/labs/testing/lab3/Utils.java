package com.almdudleer.labs.testing.lab3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utils {
    public static final By avatar = By.cssSelector("#pb-header-avatar-icon > svg");
    public static final By logInBtn = By.linkText("Log In");
    public static final By signUpBtn = By.linkText("Sign Up");

    public final WebDriver driver;
    public final WebDriverWait wait;

    public Utils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void logIn() {
        driver.get("https://app.photobucket.com");
//        if (!isLoggedIn()) {
            driver.findElement(logInBtn).click();
            driver.findElement(By.id("login-loginfield")).sendKeys("prettyfrog");
            driver.findElement(By.id("login-pass")).sendKeys("qwerty123");
            driver.findElement(By.cssSelector(".Button-sc-1mhdsiq")).click();
            wait.until(ExpectedConditions.elementToBeClickable(avatar));
//        }
    }

    public void logOut() {
        driver.get("https://app.photobucket.com/profile/account");
//        if (isLoggedIn()) {
            driver.findElement(avatar).click();
            driver.findElement(By.linkText("Log Out")).click();
//        }
    }

    public boolean isLoggedIn() {
        return elementExists(logInBtn);
    }

    public boolean elementExists(By selector) {
        return driver.findElements(selector).size() != 0;
    }
}
