package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ":nth-child(29)>a")
    WebElement jsAlerts;

    public JSAlertsPage getJSAlertsPage() {
        click(jsAlerts);
        return new JSAlertsPage(driver);
    }

    @FindBy(css = ":nth-child(34)>a")
    WebElement nestedFrames;

    public NestedFramesPage getNestedFramesPage() {
        click(nestedFrames);
        return new NestedFramesPage(driver);
    }

    @FindBy(css = ":nth-child(33)>a")
    WebElement multipleWindowsLink;

    public MultipleWindowsPage getMultipleWindowsPage() {
        click(multipleWindowsLink);
        return new MultipleWindowsPage(driver);
    }

    @FindBy(css = ":nth-child(24)>a")
    WebElement horizontalSliderLink;
    public HorizontalSliderPage getHorizontalSliderPage() {
        click(horizontalSliderLink);
        return new HorizontalSliderPage(driver);
    }

    @FindBy(css = ":nth-child(25)>a")
    WebElement hoverLink;
    public HoversPage getHoverPage() {
        click(hoverLink);
        return new HoversPage(driver);
    }
}
