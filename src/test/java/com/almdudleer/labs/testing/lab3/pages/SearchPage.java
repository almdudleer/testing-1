package com.almdudleer.labs.testing.lab3.pages;

import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends Page {
    public SearchPage(SeleniumUtils utils) {
        super(utils);
        URL = "https://app.photobucket.com/search";
    }

    public List<WebElement> search(String query) {
        utils.driver.findElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/input"))
                .sendKeys(query);
        utils.driver.findElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/button")).click();
        utils.wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/h3"), "Search results for “frog”"));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div/div/div[2]/div")));
        return utils.driver.findElements(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div/div/div[2]/div"));

    }
}
