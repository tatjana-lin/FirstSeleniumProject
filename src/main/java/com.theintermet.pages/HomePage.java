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
}
