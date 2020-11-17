package com.almdudleer.labs.testing.lab3;

public class SeleniumExample {

    private SeleniumConfig config;
    private String url = "https://app.photobucket.com/";

    public SeleniumExample() {
        config = new SeleniumConfig();
        config.getDriver().get(url);
    }

    public void closeWindow() {
        this.config.getDriver().close();
    }

    public String getTitle() {
        return this.config.getDriver().getTitle();
    }
}
