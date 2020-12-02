package com.almdudleer.labs.testing.lab3.utils;

import org.openqa.selenium.By;

public class Elements {
    public static final By avatar = By.cssSelector("#pb-header-avatar-icon > svg");
    public static final By alertSpan = By.xpath("//*[@id=\"root\"]/div[3]/span");
    public static final By alertBtn = By.xpath("//*[@id=\"root\"]/div[3]/button");
    public static final By acceptCookieBtn = By.linkText("Got it!");
}
