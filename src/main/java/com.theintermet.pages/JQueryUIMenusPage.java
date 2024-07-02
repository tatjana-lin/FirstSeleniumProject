package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JQueryUIMenusPage extends BasePage {
    public JQueryUIMenusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ui-id-3")
    WebElement mainItem2;

    @FindBy(css = "#ui-id-8>a")
    WebElement subMenuItem2;

    public JQueryUIMenusPage selectBackToJQuery() {

        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        pause(1000);
        actions.click(subMenuItem2).perform();
        pause(1000);

        return this;
    }

    @FindBy(css = ".description>p")
    WebElement description;

    public JQueryUIMenusPage verifyText(String text) {
        Assert.assertTrue(shouldHaveText(description, text, 5));
        return this;
    }

    @FindBy(id = "ui-id-4")
    WebElement subMenuItem1;

    @FindBy(css = "#ui-id-6>a")
    WebElement subSubMenuItem2;

    public JQueryUIMenusPage selectDownloadsCsvFile() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        pause(1000);
        actions.moveToElement(subMenuItem1).perform();
        pause(1000);
        actions.click(subSubMenuItem2).perform();
        pause(1000);
        return this;
    }

    public JQueryUIMenusPage verifyFilePath(String filePath) {
        Assert.assertTrue(isFileDownloaded(filePath, "menu.csv"));
        return this;
    }


}



