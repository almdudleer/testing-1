package com.almdudleer.labs.testing.lab3.pages.search;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends Page {
    By allCommunityToggle = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/div[1]/div[1]");
    By yourBucketToggle = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/div[1]/div[2]");
    public By searchInput = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/input");
    public By searchTitle = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/h3");

    public SearchPage(SeleniumUtils utils) {
        super(utils);
        Url = "https://app.photobucket.com/search";
        anchor = searchInput;
    }

    public void search(String query) {
        utils.driver.findElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/input")).sendKeys(query);
        utils.driver.findElement(By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/form/div/button")).click();
        utils.wait.until(ExpectedConditions.textToBe(searchTitle, "Search results for “" + query + "”"));
    }

    public SearchResultView openSearchResult(int num) {
        By res = getSearchResultSelector(num);
        SearchResultView resView = new SearchResultView(utils, res);
        resView.go();
        return resView;
    }

    public void selectAllCommunityToggle() {
        utils.clickElement(allCommunityToggle);
    }

    public void selectYourBucketToggle() {
        utils.clickElement(yourBucketToggle);
    }

    public By getSearchResultSelector(int num) {
        return By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div/div/div[2]/div[" + num + "]");
    }
}
