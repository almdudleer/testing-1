package com.almdudleer.labs.testing.lab3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchTest {
    private WebDriver driver;
    WebDriverWait wait;
    Utils utils;

    @BeforeEach
    public void setUp() {
        utils = new Utils();
        driver = utils.getDriver();
        wait = utils.getWait();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void findFrogImage() {
        utils.logIn();
        driver.get("https://app.photobucket.com/search");
        driver.findElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/input")).sendKeys("frog");
        driver.findElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/button")).click();
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div/div/div[2]/div")));
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/h3"), "Search results for “frog”"));
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div/div/div[2]/div"));
        elements.get(3).click();

    }
}
