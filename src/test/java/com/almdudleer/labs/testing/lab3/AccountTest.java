package com.almdudleer.labs.testing.lab3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AccountTest {
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void LogInMacro() {
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.id("login-loginfield")).sendKeys("prettyfrog");
        driver.findElement(By.id("login-pass")).sendKeys("qwerty123");
        driver.findElement(By.cssSelector(".Button-sc-1mhdsiq")).click();
    }

    @Test
    public void logInMacro() {
        {
            List<WebElement> elements = driver.findElements(By.linkText("Log In"));
            assert (elements.size() > 0);
        }
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.id("login-loginfield")).sendKeys("prettyfrog");
        driver.findElement(By.id("login-pass")).sendKeys("qwerty123");
        driver.findElement(By.cssSelector(".Button-sc-1mhdsiq")).click();
    }

    @Test
    public void logInOutTest() {
        driver.get("https://app.photobucket.com");
        LogInMacro();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#pb-header-avatar-icon > svg"));
            assert (elements.size() > 0);
        }
        logOutMacro();
        {
            List<WebElement> elements = driver.findElements(By.linkText("Log In"));
            assert (elements.size() > 0);
        }
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("a:nth-child(7) > .Button-sc-1mhdsiq"));
            assert (elements.size() > 0);
        }
    }

    @Test
    public void logOutMacro() {
        {
            List<WebElement> elements = driver.findElements(By.cssSelector("#pb-header-avatar-icon > svg"));
            assert (elements.size() > 0);
        }
        driver.findElement(By.cssSelector("#pb-header-avatar-icon > svg")).click();
        driver.findElement(By.linkText("Log Out")).click();
    }
}
