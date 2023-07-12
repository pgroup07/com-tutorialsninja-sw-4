package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {
    HomePage homePage = new HomePage();
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully()
    {
        homePage.hoverAndClickOnDesktop();
        homePage.selectMenu("Show All Desktops");
        homePage.hoverAndClickOnShowAllDesktop();
        Assert.assertEquals(homePage.getDesktopsTexts(),"Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.hoverOnLaptopsAndNotebooksTab();
        homePage.selectMenu("Show All Laptops & Notebooks");
        homePage.hoverAndClickOnLaptopsAndNotebooksTab();
        Assert.assertEquals(homePage.getLaptopsAndNotBooksText(),"Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully()
    {
        homePage.hoverOnComponents();
        homePage.hoverAndClickOnComponents();
        homePage.selectMenu("Show All Components");
        Assert.assertEquals(homePage.getComponentsText(),"Components");
    }

}
