package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.MyAccountPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Register");
        String expectedText = "Register Account";
        Assert.assertEquals(myAccountPage.getRegisterAccountText(), expectedText, "Register Account is not displayed");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Login");
        String expectedText = "Returning Customer";
        Assert.assertEquals(myAccountPage.getReturningCustomerText(), expectedText, "Returning customer is not displayed");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Register");
        myAccountPage.enterFirstName();
        myAccountPage.enterLastName();
        myAccountPage.enterEmailId();
        myAccountPage.enterTelephone();
        myAccountPage.enterPassword();
        myAccountPage.enterConfirmPassword();
        myAccountPage.clickOnYesRadioButton();
        myAccountPage.clickOnPrivacyPolicyCheckBox();
        myAccountPage.clickOnContinue();
        String expectedText = "Your Account Has Been Created!";
        Assert.assertEquals(myAccountPage.getAccountCreatedMessage(), expectedText, "Your Account Has Been Created! is not displayed");
        myAccountPage.clickOnContinueButton();
        Thread.sleep(1000);
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Logout");
        String expectedMessage = "Account Logout";
        Assert.assertEquals(myAccountPage.getAccountLogoutText(), expectedMessage, "Account Logout is not displayed");
        myAccountPage.clickContinue();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Login");
        myAccountPage.enterEmailId();
        myAccountPage.enterPassword();
        myAccountPage.clickOnLoginButton();
        String expectedText = "My Account";
        Assert.assertEquals(myAccountPage.getMyAccountText(), expectedText, "My Account is not displayed");
        myAccountPage.clickOnMyAccountLink();
        Thread.sleep(1000);
        myAccountPage.selectMyAccountOptions("Logout");
        String expectedMessage = "Account Logout";
        Assert.assertEquals(myAccountPage.getAccountLogoutText(), expectedMessage, "Account Logout is not displayed");
        myAccountPage.clickContinue();
    }

}
