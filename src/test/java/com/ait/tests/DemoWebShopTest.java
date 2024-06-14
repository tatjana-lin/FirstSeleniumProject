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



//    HW #2======================================================================
    @Test
    public void findElementsByTagName() {
//        find elements by tag
        WebElement element = driver.findElement(By.tagName("title"));
        System.out.println(element.getText());

        List<WebElement> elements = driver.findElements(By.tagName("ul"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementByLocator() {
//        by id
        WebElement element = driver.findElement(By.id("small-searchterms"));
        System.out.println(element.getLocation());

//        by class name
        List<WebElement> elements = driver.findElements(By.className("inactive"));
        System.out.println(elements.size());

        driver.findElement(By.className("master-wrapper-page"));

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
        //driver.findElement(By.className("master-wrapper-page"));
        driver.findElement(By.cssSelector(".master-wrapper-page"));

        // [attr=''value]
        WebElement cssSelector = driver.findElement(By.cssSelector("[id='ui-id-1']"));
        System.out.println(cssSelector.getAttribute("id"));
    }

    //    HW #3 ======================================================================
    @Test
    public void findElementByXpath(){

//   //*[@attr='value']

        //tag name -> //tag
        //driver.findElement(By.cssSelector("title"));
        driver.findElement(By.xpath("//title"));

        List<WebElement> elements = driver.findElements(By.xpath("//ul"));
        System.out.println(elements.size());

        //id -> //*[@id='value']
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));

        //class -> //*[@class='value']
        List<WebElement> elements1 = driver.findElements(By.xpath("//*[@class='inactive']"));

        driver.findElement(By.xpath("//*[@class='master-wrapper-page']"));

        //text = //tag[text()='Text']
        driver.findElement(By.xpath("//a[text()='Register']"));
        driver.findElement(By.xpath("//a[.='Register']"));

        //contains text -> //tag[contains(.,'Text')]
        driver.findElement(By.xpath("//a[contains(.,'Books')]"));

        //contains value -> //tag[contains(@attr,'partialValue')]
        driver.findElement(By.xpath("//*[contains(@id,'id-1')]"));

        //start -> //tag[starts-with(@attr,'startOfValue')]
        driver.findElement(By.xpath("//a[starts-with(@class,'ico')]"));

        //parent
        driver.findElement(By.xpath("//a[@class='nivo-imageLink']/.."));
        driver.findElement(By.xpath("//a[@class='nivo-imageLink']/parent::*"));
        driver.findElement(By.xpath("//a[@class='nivo-imageLink']/parent::div"));

        //ancestor
        driver.findElement(By.xpath("//a[@class='nivo-imageLink']/ancestor::*"));// all
        driver.findElement(By.xpath("//a[@class='nivo-imageLink']/ancestor::div"));// 8 options
        driver.findElement(By.xpath("//a[@class='nivo-imageLink']/ancestor::div[1]"));// one option

    }

}
