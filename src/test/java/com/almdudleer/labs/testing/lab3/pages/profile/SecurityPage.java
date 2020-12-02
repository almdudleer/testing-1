package com.almdudleer.labs.testing.lab3.pages.profile;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SecurityPage extends Page {

    private final By currentPassForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[2]/input");
    private final By newPassForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[3]/input");
    private final By newPassConfirmForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[4]/input");
    private final By saveChangesBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/button");

    public SecurityPage(SeleniumUtils utils) {
        super(utils);
        Url = "https://app.photobucket.com/profile/password_email";
        anchor = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[3]/div/div[2]/input");
    }

    public void enterPassword(String password) {
        utils.getClickableElement(currentPassForm).sendKeys(password);
    }

    public void enterNewPassword(String password) {
        utils.getClickableElement(newPassForm).sendKeys(password);
    }

    public void enterPasswordConfirmation(String password) {
        utils.getClickableElement(newPassConfirmForm).sendKeys(password);
    }

    public boolean saveChanges() {
        WebElement btn = utils.getClickableElement(saveChangesBtn);
        if (btn.isEnabled()) {
            btn.click();
            return true;
        } else {
            return false;
        }
    }

}
