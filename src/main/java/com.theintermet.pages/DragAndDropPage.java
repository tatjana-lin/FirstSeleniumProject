package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "column-a")
    WebElement columnA;

    @FindBy(id = "column-b")
    WebElement columnB;

    public DragAndDropPage dragAndDropAction() {
        new Actions(driver).dragAndDrop(columnA, columnB).perform();

        return this;
    }

    @FindBy(css = "#column-a>header")
    WebElement headerA;
    @FindBy(css = "#column-b>header")
    WebElement headerB;

    public DragAndDropPage verifyTextInBothShapes() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(shouldHaveText(headerA, "B", 5));
        softAssert.assertTrue(shouldHaveText(headerB, "A", 5));
        softAssert.assertAll();
        return this;
    }

    public DragAndDropPage verifyTextInOneShape(String text) {
        Assert.assertTrue(shouldHaveText(headerA, text, 5));
        return this;
    }

    public DragAndDropPage dragAndDropByAction(int x, int y) {

        int xOffset1 = columnA.getLocation().getX();
        int yOffset1 = columnA.getLocation().getY();
        System.out.println("Column A: x --> " + xOffset1 + " *** " + " y --> " + yOffset1);

        // get coordinates dropHere (to) and print
        int xOffset = columnB.getLocation().getX();
        int yOffset = columnB.getLocation().getY();
        System.out.println("Column B: x --> " + xOffset + " *** " + " y --> " + yOffset);

        // find the difference xOffset and yOffset
        xOffset = (xOffset - xOffset1) + x;
        yOffset = (yOffset - yOffset1) + y;

        new Actions(driver).dragAndDropBy(columnA, xOffset, yOffset).perform();

        return this;
    }
}
