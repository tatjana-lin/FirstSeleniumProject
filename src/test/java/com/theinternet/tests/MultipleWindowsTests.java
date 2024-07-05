package com.theinternet.tests;

import com.theintermet.pages.HomePage;
import com.theintermet.pages.MultipleWindowsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getMultipleWindowsPage();
    }

    @Test
    public void handleNewTabTest(){
        new MultipleWindowsPage(driver).switchToNewWindow(1)
                .verifyNewWindowTitle("New Window");
    }

}
