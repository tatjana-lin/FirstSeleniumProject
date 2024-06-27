package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindowsPage extends BasePage{

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }
@FindBy(css = ".example>a")
    WebElement openWindowLink;

    public MultipleWindowsPage switchToNewWindow(int index) {
        click(openWindowLink);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));

        return this;
    }

    @FindBy(xpath = "//h3[.='New Window']")
    WebElement newWindowTitle;

    public MultipleWindowsPage verifyNewWindowTitle(String title) {

        // метод shouldHaveText - ждёт появления текста и убеждается в том, что текст соответствует ожидаемому
        Assert.assertTrue(shouldHaveText(newWindowTitle, title, 5));
        return this;
    }
}
