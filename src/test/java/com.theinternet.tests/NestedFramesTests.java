package com.theinternet.tests;

import com.theintermet.pages.HomePage;
import com.theintermet.pages.NestedFramesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getNestedFramesPage();
    }

    @Test
    public void handleNestedFramesTest() {
        new NestedFramesPage(driver)
                .handleNestedFrames();
    }

    @Test
    public void bottomFrameTest() {
        new NestedFramesPage(driver)
                .switchToBottomFrame()
                .verifyText("BOTTOM");
    }

    @Test
    public void leftFrameTest() {
        new NestedFramesPage(driver)
                .switchToLeftFrame()
                .verifyText("LEFT");

    }

    @Test
    public void rightFrameTest() {
        new NestedFramesPage(driver)
                .switchToRightFrame()
                .verifyText("RIGHT");
    }

}
