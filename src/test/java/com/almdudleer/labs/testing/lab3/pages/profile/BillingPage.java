package com.almdudleer.labs.testing.lab3.pages.profile;

import com.almdudleer.labs.testing.lab3.pages.Page;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BillingPage extends Page {

    public static final By annualPlanToggle = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[3]/div/div/div[1]/div[2]");
    public static final By monthlyPlanToggle = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[3]/div/div/div[1]/div[1]");
    public static final By expertPlanPrice = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div[1]");
    public static final By buyExpertPlanBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[3]/div/div/div[2]/div[2]/div[2]/div[2]/button");
    public static final By payWithCardBtn = By.className("braintree-option__card");
    public static final By cardholderNameInput = By.xpath("//*[@id=\"braintree__card-view-input__cardholder-name\"]");
    public static final By cardNumberInput = By.xpath("//*[@id=\"credit-card-number\"]");
    public static final By expirationDateInput = By.xpath("//*[@id=\"expiration\"]");
    public static final By cvvInput = By.xpath("//*[@id=\"cvv\"]");
    public static final By agreeCheckbox = By.xpath("//*[@id=\"userAgreements\"]");
    public static final By submitBtn = By.xpath("//*[@id=\"overflow-container\"]/div[1]/div[2]/div[3]/div/div/button");
    public static final By cardNumberErrorMessage = By.xpath("//*[@id=\"braintree-dropin-container\"]/div[1]/div[1]/div[5]/div[5]/div[6]/div[2]/div[2]/div");
    public static final By expirationDateErrorMessage = By.xpath("//*[@id=\"braintree-dropin-container\"]/div[1]/div[1]/div[5]/div[5]/div[6]/div[2]/div[3]/div[1]/div");
    public static final By cvvCodeErrorMessage = By.xpath("//*[@id=\"braintree-dropin-container\"]/div[1]/div[1]/div[5]/div[5]/div[6]/div[2]/div[3]/div[2]/div");

    private final Common common;

    public BillingPage(Common common) {
        super(common.utils);
        this.common = common;
        Url = "https://app.photobucket.com/profile/account/billing";
    }

    public void chooseAnnualPlan() {
        utils.clickElement(annualPlanToggle);
    }

    public void chooseMonthlyPlan() {
        utils.clickElement(monthlyPlanToggle);
    }

    public void buyExpertPlan() {
        common.customActions.scrollToElement(buyExpertPlanBtn);
        utils.clickElement(buyExpertPlanBtn);
    }

    public void payWithCard() {
        utils.clickElement(payWithCardBtn);
    }

    public void enterCardholderName(String name) {
        common.customActions.scrollToElement(cardholderNameInput);
        utils.driver.findElement(cardholderNameInput).sendKeys(name);
    }

    public void enterCardNumber(String cardNumber) {
        utils.driver.switchTo().frame(utils.driver.findElement(By.xpath("//*[@id=\"braintree-hosted-field-number\"]")));
        common.customActions.scrollToElement(cardNumberInput);
        utils.driver.findElement(cardNumberInput).sendKeys(cardNumber);
        utils.driver.switchTo().defaultContent();
    }

    public void enterCardExpirationDay(String date) {
        utils.driver.switchTo().frame(utils.driver.findElement(By.xpath("//*[@id=\"braintree-hosted-field-expirationDate\"]")));
        common.customActions.scrollToElement(expirationDateInput);
        utils.driver.findElement(expirationDateInput).sendKeys(date);
        utils.driver.switchTo().defaultContent();
    }

    public void enterCardCvvCode(String cvv) {
        utils.driver.switchTo().frame(utils.driver.findElement(By.xpath("//*[@id=\"braintree-hosted-field-cvv\"]")));
        common.customActions.scrollToElement(cvvInput);
        utils.driver.findElement(cvvInput).sendKeys(cvv);
        utils.driver.switchTo().defaultContent();
    }

    public void acceptTermsOfService() {
        common.customActions.scrollToElement(agreeCheckbox);
        utils.clickElement(agreeCheckbox);
    }

    public void submitCardForm() {
        common.customActions.scrollToElement(submitBtn);
        utils.clickElement(submitBtn);
    }

    public String getExpertPlanCost() {
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(expertPlanPrice));
        return utils.driver.findElement(expertPlanPrice).getText();
    }

    public String getCardNumberErrorMessageText() {
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(cardNumberErrorMessage));
        return utils.driver.findElement(cardNumberErrorMessage).getText();
    }

    public String getCvvNumberErrorMessageText() {
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(cvvCodeErrorMessage));
        return utils.driver.findElement(cvvCodeErrorMessage).getText();
    }

    public String getExpirationDateErrorMessageText() {
        utils.wait.until(ExpectedConditions.presenceOfElementLocated(expirationDateErrorMessage));
        return utils.driver.findElement(expirationDateErrorMessage).getText();
    }
}
