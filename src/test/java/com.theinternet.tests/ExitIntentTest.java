package com.theinternet.tests;

import com.theintermet.pages.ExitIntentPage;
import com.theintermet.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExitIntentTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getExitIntentPage();
    }

    @Test
    public void exitIntentTest(){
        new ExitIntentPage(driver).moveMouseOut()
                .verifyModalWindowIsDisplayed();
    }

}
