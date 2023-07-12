package com.tutorialsninja.testbase;

import com.tutorialsninja.propertyreader.PropertyReader;
import com.tutorialsninja.utilities.Utility;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utility {
    String browser= PropertyReader.getInstance().getProperty("browser");;
    @BeforeMethod
    public void setUp()
    {
        selectBrowser(browser);
    }
    @AfterTest
    public void teardown()
    {
        closeBrowser();
    }
}
