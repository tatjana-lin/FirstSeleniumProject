package com.ait.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DemoWebShopTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void openDemoWebShop(){
        System.out.println("DemoWebShop opened!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void findElementsByTagName() {
//        find elements by tag
        WebElement element = driver.findElement(By.tagName("strong"));
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.tagName("ul"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementByLocator() {
//        by id
        WebElement element = driver.findElement(By.id("nivo-slider"));
        System.out.println(element.getLocation());

//        by class name
        List<WebElement> elements = driver.findElements(By.className("inactive"));
        System.out.println(elements.size());

//        link text
        WebElement linkText = driver.findElement(By.linkText("Books"));
        System.out.println(linkText.getText());

//        partial link text
        WebElement partialLinkText = driver.findElement(By.partialLinkText("Gift"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //tag name -> tag
        //driver.findElement(By.tagName("h2"));
        driver.findElement(By.cssSelector("h2"));


        //id -> #id
        // driver.findElement(By.id("nivo-slider"));
        driver.findElement(By.cssSelector("#nivo-slider"));

        //class -> .class
        //driver.findElement(By.className("inactive"));
        driver.findElement(By.cssSelector(".inactive"));

        // [attr=''value]
        WebElement cssSelector = driver.findElement(By.cssSelector("[id='ui-id-1']"));
        System.out.println(cssSelector.getAttribute("id"));

    }


}
