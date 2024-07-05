package com.theinternet.tests;

import com.theintermet.pages.ContextMenuPage;
import com.theintermet.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getContextMenuPage();
    }

    @Test
    public void contextMenuTest(){
        new ContextMenuPage(driver).rightClickOnTheElement()
                .verifyIsAlertPresent();
    }
}
