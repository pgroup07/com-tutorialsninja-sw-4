package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException
    {
        homePage.hoverOnLaptopsAndNotebooksTab();
        homePage.selectMenu("Show All Laptops & Notebooks");
        homePage.hoverAndClickOnLaptopsAndNotebooksTab();
        Thread.sleep(1000);
        laptopsAndNotebooksPage.selectSortByPriceHighToLow();
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException
    {
        homePage.hoverOnLaptopsAndNotebooksTab();
        homePage.selectMenu("Show All Laptops & Notebooks");
        homePage.hoverAndClickOnLaptopsAndNotebooksTab();
        Thread.sleep(1000);
        laptopsAndNotebooksPage.selectSortByPriceHighToLow();
        laptopsAndNotebooksPage.selectProductMacbook();
        String expectedText = "MacBook";
        Assert.assertEquals(laptopsAndNotebooksPage.getMacbookText(), expectedText, "MacBook text is not displayed");
        laptopsAndNotebooksPage.clickOnAddToCartButton();
        String expectedMessage = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccessMessage(), expectedMessage, "Success message is not displayed");
        laptopsAndNotebooksPage.clickOnShoppingCartText();
        Assert.assertEquals(laptopsAndNotebooksPage.getShoppingCartText(), "Shopping Cart  (0.00kg)", "Shopping cart message is not displayed");
        laptopsAndNotebooksPage.clearQuantityField();
        laptopsAndNotebooksPage.addQuantityInField();
        laptopsAndNotebooksPage.clickOnUpdateTab();
        String expectedSuccessMessage = "Success: You have modified your shopping cart!\n" +
                "×";
        Assert.assertEquals(laptopsAndNotebooksPage.getSuccessModifiedMessage(), expectedSuccessMessage, "Success modified message is not displayed");
        laptopsAndNotebooksPage.clickOnCurrency();
        laptopsAndNotebooksPage.selectSterlingPound();
        Assert.assertEquals(laptopsAndNotebooksPage.getTotal(), "£737.45", "£737.45 is not coming");
        laptopsAndNotebooksPage.clickOnCheckOut();
        Assert.assertEquals(laptopsAndNotebooksPage.getCheckOutText(), "Checkout", "Checkout is not displayed");
        Thread.sleep(1000);
        Assert.assertEquals(laptopsAndNotebooksPage.getNewCustomerText(), "New Customer", "New Customer is not displayed");
        laptopsAndNotebooksPage.clickOnGuestCheckOutRadioButton();
        Thread.sleep(1000);
        laptopsAndNotebooksPage.clickOnContinueTab();
        laptopsAndNotebooksPage.fillAllMandatoryField();
        Thread.sleep(1000);
        laptopsAndNotebooksPage.clickOnContinueButton();
        laptopsAndNotebooksPage.addCommentInCommentBox();
        laptopsAndNotebooksPage.clickOnTermsAndConditionsCheckBox();
        laptopsAndNotebooksPage.clickOnContinue();
        String expectedWarningMessage = "Warning: Payment method required!\n" +
                "×";
        Assert.assertEquals(laptopsAndNotebooksPage.getWarningMessage(), expectedWarningMessage, "Warning message is not displayed");

    }
}
