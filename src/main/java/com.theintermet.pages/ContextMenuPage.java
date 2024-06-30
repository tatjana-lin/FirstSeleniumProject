package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContextMenuPage extends BasePage{
    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "hot-spot")
    WebElement hot_spot;

    public ContextMenuPage rightClickOnTheElement() {
        new Actions(driver).contextClick(hot_spot).perform();
        return this;
    }

    public ContextMenuPage verifyIsAlertPresent() {
        Assert.assertTrue(isAlertPresent());
        return this;
    }

}
