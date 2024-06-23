package com.demowebshop.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public boolean isTextPresent(By locator, String text) {
        List<WebElement> items = driver.findElements(locator);

        for (WebElement item : items) {
            if (item.getText().contains(text)) return true;
        }
        return false;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

public String takeScreenshot(){
    File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
    try {
        Files.copy(tmp,screenshot);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    return screenshot.getAbsolutePath();
}

}
