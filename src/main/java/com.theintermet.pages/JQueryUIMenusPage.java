package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;

public class JQueryUIMenusPage extends BasePage {
    public JQueryUIMenusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ui-id-3")
    WebElement enabled;

    @FindBy(css = "#ui-id-8>a")
    WebElement back;

    public JQueryUIMenusPage selectBackToJQuery() {

        Actions actions = new Actions(driver);
        actions.moveToElement(enabled).perform();
        pause(1000);
        actions.click(back).perform();
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
    WebElement download;
    @FindBy(css = "#ui-id-5>a")
    WebElement pdf;
    @FindBy(css = "#ui-id-6>a")
    WebElement csv;
    @FindBy(css = "#ui-id-7>a")
    WebElement excel;


    public JQueryUIMenusPage hoverEnabled() {
        new Actions(driver).moveToElement(enabled).perform();
        pause(1000);
        return this;
    }

    public JQueryUIMenusPage hoverDownloads() {
        new Actions(driver).moveToElement(download).perform();
        pause(1000);
        return this;
    }

    public JQueryUIMenusPage clickPdf() {
        click(pdf);
        return this;
    }

    public JQueryUIMenusPage clickCsv() {
        click(csv);
        return this;
    }

    public JQueryUIMenusPage clickExcel() {
        click(excel);
        return this;
    }

    public JQueryUIMenusPage checkFileDownloaded(String path, String name) {
        pause(2000);
        Assert.assertTrue(isFileDownloaded(path,name));
        pause(1000);
        return null;
    }

    public JQueryUIMenusPage removeDownloadedFile(String path, String name) {
        pause(2000);
        File dir = new File(path);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(name)) {
                dirContents[i].delete();
                return this;
            }
        }
        return this;
    }

}



