package com.theintermet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }
    public void type(WebElement element, String text){
        if(text!=null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            ex.getMessage();
            return false;
        }
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }else{
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }

    public void clickWithRectangle(WebElement element, int x, int y){
        Rectangle rectangle = element.getRect();
        int offSetX = rectangle.getWidth() / x;
        int offSetY = rectangle.getHeight() / y;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offSetX,-offSetY).click().perform();

    }

    public boolean isFileDownloaded(String filePath, String fileName) {
        File downloads = new File(filePath);
        File[] downloadsContent = downloads.listFiles();
        for (File file : downloadsContent) {
            if (file.getName().contains(fileName)) {
                file.delete();
                return true;
            }
        }
        return false;
    }
}
