package com.theinternet.tests;

import com.theintermet.pages.DragAndDropPage;
import com.theintermet.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDragAndDropPage();
    }

    @Test
    public void dragAndDropTest() {
        new DragAndDropPage(driver).dragAndDropAction().verifyText();
    }

    @Test
    public void dragAndDropTest1() {
        new DragAndDropPage(driver).dragAndDropAction().verifyText1("B");
    }

    @Test
    public void dragAndDropByTest() {
        new DragAndDropPage(driver).dragAndDropByAction(0,0).verifyText();
    }

}
