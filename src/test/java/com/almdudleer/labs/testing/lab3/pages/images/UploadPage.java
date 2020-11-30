package com.almdudleer.labs.testing.lab3.pages.images;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class UploadPage extends Page {
    public final static By uploadInput = By.xpath("//*[@id=\"pb-upload-select-photo-button\"]");
    public final static By addAlbumBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[1]/div[4]");
    public final static By createAlbumBtn = By.xpath("//*[@id=\"root\"]/div[4]/div[3]");
    public final static By newAlbumNameInput = By.xpath("//*[@id=\"drag-id-fakeid-1606775199424\"]/div/div/input");
    public final static By albumsList = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[3]/div[1]/div[1]/div/div[2]/div");


    private final Common common;

    public UploadPage(Common common) {
        super(common.utils);
        this.common = common;
        Url = "https://app.photobucket.com/upload";
    }

    public void uploadFile(String filename) throws URISyntaxException {
        URL res = getClass().getClassLoader().getResource(filename);
        File file = Paths.get(res.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        utils.driver.findElement(uploadInput).sendKeys(absolutePath);
    }

    public void addAlbum(String albumName) {
        utils.clickElement(addAlbumBtn);
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(newAlbumNameInput));
        utils.driver.findElement(newAlbumNameInput).sendKeys(Keys.chord(Keys.CONTROL, "a"), albumName, Keys.ENTER);
    }

    public List<String> getAlbumsNames() {
        System.out.println(utils.driver.findElements(albumsList));
        return null;
    }
}
