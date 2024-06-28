package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HoversPage extends BasePage {
    public HoversPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//div[@class='figure'][1]")
    WebElement figure1;
    @FindBy(xpath = "//div[@class='figure'][2]")
    WebElement figure2;
    @FindBy(xpath = "//div[@class='figure'][3]")
    WebElement figure3;

    WebElement[] figures = {figure1, figure2, figure3};


    @FindBy(xpath = "//div[@class='figure'][1]//a")
    WebElement info1;

    @FindBy(xpath = "//div[@class='figure'][2]//a")
    WebElement info2;

    @FindBy(xpath = "//div[@class='figure'][3]//a")
    WebElement info3;

    WebElement[] infos = {info1, info2, info3};

    public HoversPage verifyInfo(int i) {
        Assert.assertTrue(isElementVisible(infos[i - 1]));
        return this;
    }

    public HoversPage hoverOver(int i) {
        actions.moveToElement(figures[i - 1]).pause(1000).perform();
        return this;
    }

    public HoversPage hoverOverAndVerifyInfo() {
        Actions actions = new Actions(driver);
        for (int i = 0; i < figures.length; i++) {
            actions.moveToElement(figures[i]).pause(1000).perform();
            Assert.assertTrue(isElementVisible(infos[i]));
        }
        return this;
    }

}
