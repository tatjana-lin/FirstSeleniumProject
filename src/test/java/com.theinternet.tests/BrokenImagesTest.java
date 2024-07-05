package com.theinternet.tests;

import com.theintermet.pages.BrokenImagesPage;
import com.theintermet.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImagesTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBrokenImagesPage();
    }

//    на битых картинках тест ДОЛЖЕН УПАСТЬ!
    @Test
    public void checkBrokenImageTest() {
        new BrokenImagesPage(driver).defineLinksOfImages()
                .checkImageIsBroken();
    }

}
