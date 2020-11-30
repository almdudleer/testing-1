package com.almdudleer.labs.testing.lab3.tests;

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
        explorePage = new ExplorePage(common);
        billingPage = new BillingPage(common);
    }

    @AfterEach
    public void tearDown() {
        common.utils.driver.quit();
    }

    @Test
    public void upgradePlanTest() {
        common.customActions.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
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
        common.customActions.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        billingPage.go();
        billingPage.chooseAnnualPlan();
        Assertions.assertEquals("$11.69\na month", billingPage.getExpertPlanCost());
    }

    @Test
    void testSwitchToMonthly() {
        common.customActions.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        billingPage.go();
        Assertions.assertEquals("$12.99\na month", billingPage.getExpertPlanCost());
    }

    @Test
    void testSwitchToAnnualThemBackToMonthly() {
        common.customActions.logInCorrect();
        common.utils.wait.until(ExpectedConditions.elementToBeClickable(avatar));
        billingPage.go();
        billingPage.chooseAnnualPlan();
        billingPage.chooseMonthlyPlan();
        Assertions.assertEquals("$12.99\na month", billingPage.getExpertPlanCost());
    }
}
