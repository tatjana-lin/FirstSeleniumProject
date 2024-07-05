package com.theinternet.tests;

import com.theintermet.pages.HomePage;
import com.theintermet.pages.JSAlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJSAlertsPage();
    }

    @Test
    public void alertTest() {
        new JSAlertsPage(driver)
                .simpleAlert()
                .verifyResult("You successfully clicked an alert");
    }

    @Test
    public void confirmTest() {
        new JSAlertsPage(driver)
                .selectResult("Cancel")
                .verifyResult("Cancel");;
    }

    @Test
    public void sendMessageToPromptTest(){
        new JSAlertsPage(driver)
                .sendMessageToPrompt("Hello!")
                .verifyResult("Hello!");
    }

}
