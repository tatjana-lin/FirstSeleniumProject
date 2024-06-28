package com.theintermet.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HorizontalSliderPage extends BasePage {
    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sliderContainer>input")
    WebElement slider;

    public HorizontalSliderPage moveSlider() {

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 70, 0).pause(1000).perform();

        return this;
    }

    @FindBy(id = "range")
    WebElement range;

    public HorizontalSliderPage verifySliderValue(String value) {
        Assert.assertEquals(range.getText(),value);

        return this;
    }
}
