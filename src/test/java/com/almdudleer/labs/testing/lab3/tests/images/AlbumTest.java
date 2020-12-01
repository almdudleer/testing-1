package com.almdudleer.labs.testing.lab3.tests.images;

import com.almdudleer.labs.testing.lab3.pages.images.BucketPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class AlbumTest {
    Common common;
    BucketPage bucketPage;

    @BeforeEach
    public void setUp() {
        common = new Common();
        bucketPage = new BucketPage(common);
    }

    @AfterEach
    public void tearDown() {
        common.utils.driver.quit();
    }

    @Test
    void testAddAlbum() {
        String albumName = "Best Album Ever";
        common.appUtils.logInCorrect();
        bucketPage.go();
        bucketPage.addAlbum(albumName);
        Assertions.assertEquals(albumName, bucketPage.getAlbumsNames().get(0));
    }

    @Test
    void testAddAndDeleteAlbum() {
        String albumName = UUID.randomUUID().toString();
        common.appUtils.logInCorrect();
        bucketPage.go();
        bucketPage.addAlbum(albumName);
        bucketPage.deleteAlbumByIndex(0); // Мб стоит переписать на byName, но пока лень
        Assertions.assertNotEquals(albumName, bucketPage.getAlbumsNames().get(0));
    }
}
