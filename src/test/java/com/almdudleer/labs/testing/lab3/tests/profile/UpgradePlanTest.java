package com.almdudleer.labs.testing.lab3.tests.profile;

import com.almdudleer.labs.testing.lab3.pages.ExplorePage;
import com.almdudleer.labs.testing.lab3.pages.profile.BillingPage;
import com.almdudleer.labs.testing.lab3.utils.Common;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.almdudleer.labs.testing.lab3.utils.Elements.avatar;

public class UpgradePlanTest {
    Common common;
    ExplorePage explorePage;
    BillingPage billingPage;

    @BeforeEach
    public void setUp() {
        common = new Common();
        explorePage = new ExplorePage(common.utils);
        billingPage = new BillingPage(common);
    }

    @AfterEach
    public void tearDown() {
        common.tearDown();
    }

    @Test
    public void upgradePlanTest() {
        common.appUtils.logInCorrect();
        explorePage.go();
        explorePage.upgradeYourPlan();
        billingPage.buyExpertPlan();
        billingPage.payWithCard();
        billingPage.enterCardholderName("Ibraimov Edem");
        billingPage.enterCardNumber("5404 3619 4074 9499");
        billingPage.enterCardExpirationDay("1224");
        billingPage.enterCardCvvCode("322");
        billingPage.acceptTermsOfService();
        billingPage.submitCardForm();
    }

    @Test
    void testSwitchToAnnual() {
        common.appUtils.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        billingPage.go();
        billingPage.chooseAnnualPlan();
        Assertions.assertEquals("$11.69\na month", billingPage.getExpertPlanCost());
    }

    @Test
    void testSwitchToMonthly() {
        common.appUtils.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        billingPage.go();
        Assertions.assertEquals("$12.99\na month", billingPage.getExpertPlanCost());
    }

    @Test
    void testSwitchToAnnualThemBackToMonthly() {
        common.appUtils.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        billingPage.go();
        billingPage.chooseAnnualPlan();
        billingPage.chooseMonthlyPlan();
        Assertions.assertEquals("$12.99\na month", billingPage.getExpertPlanCost());
    }

    @Test
    void testIncorrectCardNumber() {
        common.appUtils.logInCorrect();
        explorePage.go();
        explorePage.upgradeYourPlan();
        billingPage.buyExpertPlan();
        billingPage.payWithCard();
        billingPage.enterCardNumber("1234 1234 1234 1234");
        common.utils.driver.findElement(BillingPage.cardholderNameInput).sendKeys("");
        Assertions.assertEquals("This card number is not valid.", billingPage.getCardNumberErrorMessageText());
    }

    @Test
    void testIncorrectCardCvvCode() {
        common.appUtils.logInCorrect();
        explorePage.go();
        explorePage.upgradeYourPlan();
        billingPage.buyExpertPlan();
        billingPage.payWithCard();
        billingPage.enterCardCvvCode("1");
        common.utils.driver.findElement(BillingPage.cardholderNameInput).sendKeys("");
        Assertions.assertEquals("This security code is not valid.", billingPage.getCvvNumberErrorMessageText());
    }

    @Test
    void testIncorrectExpirationDate() {
        common.appUtils.logInCorrect();
        explorePage.go();
        explorePage.upgradeYourPlan();
        billingPage.buyExpertPlan();
        billingPage.payWithCard();
        billingPage.enterCardExpirationDay("0101");
        common.utils.driver.findElement(BillingPage.cardholderNameInput).sendKeys("");
        Assertions.assertEquals("This expiration date is not valid.", billingPage.getExpirationDateErrorMessageText());
    }
}
