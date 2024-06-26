package com.theinternet.tests;

import com.theintermet.pages.HomePage;
import com.theintermet.pages.HoversPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getHoverPage();
    }

    @Test
    public void hoverTest() {
        new HoversPage(driver).hoverOverFigure(1).verifyInfo(1);
    }

}
