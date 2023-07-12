package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By selectMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopTab = By.xpath("//a[text()='Desktops']");
    By ShowAll = By.xpath("//a[contains(text(),'Show AllDesktops')]");
    By showAllComponents = By.xpath("//a[contains(text(),'Show AllComponents')]");
    By desktopsText = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsAndNotebooksTab = By.linkText("Laptops & Notebooks");
    By showAllLaptopAndNoteBooks = By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]");
    By laptopsAndNotBooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By componentsTab = By.linkText("Components");
    By componentsText = By.xpath("//h2[contains(text(),'Components')]");

    public void selectMenu(String menu) {
        List<WebElement> topMenuList = driver.findElements(selectMenu);
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(selectMenu);
        }
    }

    public void hoverAndClickOnDesktop() {
        mouseHoverToElementAndClick(desktopTab);
    }

    public void hoverAndClickOnShowAllDesktop() {
        mouseHoverToElementAndClick(ShowAll);
    }

    public String getDesktopsTexts() {
        return getTextFromElement(desktopsText);
    }

    public void hoverOnLaptopsAndNotebooksTab() {
        mouseHoverToElementAndClick(laptopsAndNotebooksTab);
    }

    public void hoverAndClickOnLaptopsAndNotebooksTab() {
        mouseHoverToElementAndClick(showAllLaptopAndNoteBooks);
    }

    public String getLaptopsAndNotBooksText() {
        return getTextFromElement(laptopsAndNotBooksText);
    }

    public void hoverOnComponents() {
        mouseHoverToElementAndClick(componentsTab);
    }

    public void hoverAndClickOnComponents() {
        mouseHoverToElementAndClick(showAllComponents);
    }

    public String getComponentsText() {
        return getTextFromElement(componentsText);
    }

}
