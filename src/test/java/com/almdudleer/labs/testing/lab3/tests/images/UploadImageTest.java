package com.almdudleer.labs.testing.lab3.tests.images;

import com.almdudleer.labs.testing.lab3.pages.images.BucketPage;
import com.almdudleer.labs.testing.lab3.pages.images.UploadPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URISyntaxException;
import java.util.UUID;

public class UploadImageTest {
    Common common;
    UploadPage uploadPage;
    BucketPage bucketPage;

    @BeforeEach
    public void setUp() {
        common = new Common();
        uploadPage = new UploadPage(common);
        bucketPage = new BucketPage(common);
    }

    @AfterEach
    public void tearDown() {
        common.utils.driver.quit();
    }

    @Test
    void uploadValidJpgToBucket() throws URISyntaxException {
        By uploadedImage = By.xpath("//img[contains(@alt, 'the_most_random_pic_name')]");
        common.appUtils.logInCorrect();
        uploadPage.go();
        uploadPage.fillFileField("com/almdudleer/labs/testing/lab3/the_most_random_pic_name.jpg");
        uploadPage.submitUploadedFiles();
        bucketPage.go();
        bucketPage.deleteAllImagesLocated(uploadedImage);
        uploadPage.go();
        uploadPage.fillFileField("com/almdudleer/labs/testing/lab3/the_most_random_pic_name.jpg");
        uploadPage.submitUploadedFiles();
        bucketPage.go();
        common.utils.wait.until(ExpectedConditions.presenceOfElementLocated(uploadedImage));
    }

    @Test
    void uploadValidImageToNewAlbum() throws URISyntaxException {
        By uploadedImage = By.xpath("//img[contains(@alt, 'the_most_random_pic_name')]");
        common.appUtils.logInCorrect();
        uploadPage.go();
        uploadPage.fillFileField("com/almdudleer/labs/testing/lab3/the_most_random_pic_name.jpg");
        common.utils.clickElement(UploadPage.chooseAnotherAlbumBtn);
        String albumName = UUID.randomUUID().toString();
        uploadPage.createNewAlbum(albumName);
        common.utils.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[4]/div[4]/div/div/div//div[text()[contains(., '" + albumName + "')]]")));
        common.utils.clickElement(UploadPage.confirmChosenAlbumBtn);
        uploadPage.submitUploadedFiles();
        common.utils.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(uploadedImage, 0));
        bucketPage.go();
        bucketPage.deleteAlbumByName(albumName);
    }
}
