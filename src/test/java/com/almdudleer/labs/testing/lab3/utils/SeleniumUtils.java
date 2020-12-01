package com.almdudleer.labs.testing.lab3.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SeleniumUtils {
    public final WebDriver driver;
    public final WebDriverWait wait;

    public SeleniumUtils() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public boolean elementExists(By selector) {
        return !driver.findElements(selector).isEmpty();
    }

    public void clickElement(By selector) {
        wait.until(ExpectedConditions.elementToBeClickable(selector));
        driver.findElement(selector).click();
    }
}
