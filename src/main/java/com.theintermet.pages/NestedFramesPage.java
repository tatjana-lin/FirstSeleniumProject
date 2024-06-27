package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class NestedFramesPage extends BasePage {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "frame")
    List<WebElement> frames;

    @FindBy(name = "frame-top")
    WebElement frameTop;

    @FindBy(name = "frame-bottom")
    WebElement frameBottom;

    @FindBy(name = "frame-left")
    WebElement frameLeft;

    @FindBy(name = "frame-middle")
    WebElement frameMiddle;

    @FindBy(name = "frame-right")
    WebElement frameRight;

    @FindBy(css = "body")
    WebElement body;


    public NestedFramesPage handleNestedFrames() {

        System.out.println("Number of frames on the page is " + frames.size()); // 2
        //        switch to parent frame-top
        driver.switchTo().frame(frameTop);
        //          get number of frames on the parent frame
        System.out.println("Number of frame-top children is " + frames.size()); // 3
        driver.switchTo().frame(frameMiddle);
        //        get text from child frame
        System.out.println("Frame is " + body.getText());
        //        return to parent frame frame-top
        driver.switchTo().parentFrame();
        //          get number of frames on the parent frame
        System.out.println("Number of frame-top children is " + frames.size());
        //        return to the main page
        driver.switchTo().defaultContent();
        //        switch to sibling frame
        driver.switchTo().frame(frameBottom);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameTop);
        System.out.println("Number of frame-top children is " + frames.size());
        //        switch by index
        driver.switchTo().frame(2);
        System.out.println("Frame is " + body.getText());// RIGHT
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println("Frame is " + body.getText());// BOTTOM

        return this;
    }

    public NestedFramesPage switchToBottomFrame() {
        driver.switchTo().frame(frameBottom);
        return this;
    }

    public NestedFramesPage verifyText(String text) {
        Assert.assertTrue(body.getText().contains(text));
        return this;
    }

    public NestedFramesPage switchToLeftFrame() {
        driver.switchTo().frame(frameTop).switchTo().frame(frameLeft);
        return this;
    }

    public NestedFramesPage switchToRightFrame() {
        driver.switchTo().frame(frameTop).switchTo().frame(2);
        return this;
    }
}
