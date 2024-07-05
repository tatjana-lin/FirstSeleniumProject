package com.theinternet.tests;

import com.theintermet.pages.HomePage;
import com.theintermet.pages.HorizontalSliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getHorizontalSliderPage();
    }

    @Test
    public void horizontalSliderTest(){
        new HorizontalSliderPage(driver).moveSlider()
                .verifySliderValue("5");
    }
}
