package com.almdudleer.labs.testing.lab3.pages.profile;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage extends Page {
    public final By firstNameForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[2]/input");
    public final By lastNameForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[3]/input");
    public final By emailForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[5]/input");
    public final By zipCodeForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[7]/input");

    public final By birthDateForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[4]/input");

    public final By locationForm = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[6]/div");
    public final By currentLocationDiv =
            By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[6]/div/div[1]/div[1]");

    private final By saveButton = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/button");


    public PersonalInfoPage(SeleniumUtils utils) {
        super(utils);
        Url = "https://app.photobucket.com/profile/personal_details";
        anchor = firstNameForm;
    }

    public void enterFirstName(String firstName) {
        if (firstName != null) {
            WebElement form = utils.getClickableElement(firstNameForm);
            form.clear();
            form.sendKeys(firstName);
        }
    }

    public void enterLastName(String lastName) {
        if (lastName != null) {
            WebElement form = utils.getClickableElement(lastNameForm);
            form.clear();
            form.sendKeys(lastName);
        }
    }

    public void enterEmail(String email) {
        if (email != null) {
            WebElement form = utils.getClickableElement(emailForm);
            form.clear();
            form.sendKeys(email);
        }
    }

    public void enterZipCode(String zipCode) {
        if (zipCode != null) {
            WebElement form = utils.getClickableElement(zipCodeForm);
            form.clear();
            form.sendKeys(zipCode);
        }
    }

    public void switchBirthDate() {
        utils.clickElement(birthDateForm);
        if (getBirthDate().equals("2003-12-18")) {
            utils.clickElement(By
                    .xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[5]/div/div[2]/div/div/div[2]/button[19]"));
        } else {
            utils.clickElement(By
                    .xpath("//*[@id=\"overflow-container\"]/div[1]/div/div[3]/div/div[5]/div/div[2]/div/div/div[2]/button[18]"));
        }
    }

    public void switchLocation() {
        utils.clickElement(locationForm);
        if (getCurrentLocation().equals("Afghanistan")) {
            utils.clickElement(By
                    .xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/div[6]/div[2]/div/div[2]"));
        } else {
            utils.clickElement(By
                    .xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div/div[3]/div/div[6]/div[2]/div/div[1]"));
        }
    }

    public boolean saveChanges() {
        if (utils.driver.findElement(saveButton).isEnabled()) {
            utils.clickElement(saveButton);
            return true;
        } else {
            return false;
        }
    }

    public String getFirstName() {
        return utils.getClickableElement(firstNameForm).getAttribute("value");
    }

    public String getLastName() {
        return utils.getClickableElement(lastNameForm).getAttribute("value");
    }

    public String getEmail() {
        return utils.getClickableElement(emailForm).getAttribute("value");
    }

    public String getBirthDate() {
        return utils.getClickableElement(birthDateForm).getAttribute("value");
    }

    public String getCurrentLocation() {
        return utils.getClickableElement(currentLocationDiv).getText();
    }

    public String getZipCode() {
        return utils.getClickableElement(zipCodeForm).getAttribute("value");
    }

}
