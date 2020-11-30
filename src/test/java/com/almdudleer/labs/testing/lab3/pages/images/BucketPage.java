package com.almdudleer.labs.testing.lab3.pages.images;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class BucketPage extends Page {
    public final static By addAlbumBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/div[4]");
    public final static By createAlbumBtn = By.xpath("//*[@id=\"root\"]/div[4]/div[3]");
    public final static By newAlbumNameInput = By.className("gallery-album-title-input");
    public final static By albumsTitles = By.className("AlbumTitle-sc-1s262m9");
    public final static By albumsTiles = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[3]/div[1]/div[1]/div/div[2]");
    public final static By deleteAlbumBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[1]/div/div[9]");
    public final static By confirmDeleteBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[1]/button[2]");
    public final static By cancelDeleteBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[1]/button[1]");



    private final Common common;

    public BucketPage(Common common) {
        super(common.utils);
        this.common = common;
        Url = "https://app.photobucket.com/u/prettyfrog";
    }

    public void addAlbum(String albumName) {
        int albumsCount = utils.driver.findElements(albumsTitles).size();
        utils.clickElement(addAlbumBtn);
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(newAlbumNameInput));
        utils.driver.findElement(newAlbumNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a"), albumName, Keys.ENTER);
        utils.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(albumsTitles, albumsCount));
    }

    public List<String> getAlbumsNames() {
        return utils.driver.findElements(albumsTitles).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void deleteAlbumByIndex(int index) {
        int albumsCount = utils.driver.findElements(albumsTitles).size();
        utils.driver.findElements(albumsTiles).get(index).click();
        utils.clickElement(deleteAlbumBtn);
        utils.clickElement(confirmDeleteBtn);
        utils.wait.until(ExpectedConditions.numberOfElementsToBeLessThan(albumsTitles, albumsCount));
    }
}
