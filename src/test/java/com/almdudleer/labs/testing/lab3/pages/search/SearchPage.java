package com.almdudleer.labs.testing.lab3.pages.search;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchPage extends Page {
    public SearchPage(SeleniumUtils utils) {
        super(utils);
        Url = "https://app.photobucket.com/search";
        anchor = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/input");
    }

    public List<WebElement> search(String query) {
        utils.driver.findElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/input")).sendKeys(query);
        utils.driver.findElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/button")).click();
        utils.wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/h3"), "Search results for “frog”"));
        return utils.driver.findElements(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div/div/div[2]/div"));
    }

    public SearchResultView openSearchResult(List<WebElement> searchResults, int num) {
        utils.wait.until(ExpectedConditions.elementToBeClickable(searchResults.get(num)));
        searchResults.get(num).click();
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//*[@id=\"overflow-container\"]/div[1]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]")));
        return new SearchResultView(utils);
    }
}
