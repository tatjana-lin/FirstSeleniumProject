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

    @Test
    public void allImagesOnThePageTest() {
        new BrokenImagesPage(driver).checkAllImages();
    }

    @Test
    public void oneImageTest() {
        new BrokenImagesPage(driver).checkIsImageBroken(1);
    }

}
