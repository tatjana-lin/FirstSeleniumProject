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

public class FindElementsTests{

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.get("https://ilcarro.web.app");
        //maximize browser to window size
        driver.manage().window().maximize();
        //wait for all elements on the site to load before start testing
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementsByTagName() {

        //find element by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //find elements by tag
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    @Test
    public void findElementByLocator() {
        //by id
        driver.findElement(By.id("city"));

        //by class name
        WebElement phone = driver.findElement(By.className("telephone"));
        System.out.println(phone.getText());

        //link text
        WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        System.out.println(linkText.getText());

        //partial link text
        WebElement partialLinkText = driver.findElement(By.partialLinkText("work"));
        System.out.println(partialLinkText.getText());
    }

    @Test
    public void findElementByCssSelector() {
        //tag name -> tag
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        //id -> #id
        // driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        //class -> .class
        //driver.findElement(By.className("telephone"));
        driver.findElement(By.cssSelector(".telephone"));

        // [attr=''value]
        WebElement cssSelector = driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        System.out.println(cssSelector.getAttribute("type"));

        //contains -> *
        WebElement elementContains = driver.findElement(By.cssSelector("[ng-reflect-router-link*='car']"));
        System.out.println(elementContains.getText());

        //start -> ^
        driver.findElement(By.cssSelector("[ng-reflect-router-link^='let']"));

        //ent on -> $
        driver.findElement(By.cssSelector("[ng-reflect-router-link$='work']"));
    }

    @Test
    public void findElementByXpath() {
        //   //*[@attr='value']

        //tag name -> //tag
        //driver.findElement(By.cssSelector("h1"));
        driver.findElement(By.xpath("//h1"));

        //id -> //*[@id='value']
        //driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        //class -> //*[@class='value']
        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//*[@class='telephone']"));

        //text = //tag[text()='Text']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));

        //contains text -> //tag[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla!')]"));

        //contains value -> //tag[contains(@attr,'partialValue')]
        driver.findElement(By.xpath("//input[contains(@class,'target')]"));
        // driver.findElement(By.xpath("//div/input[@id=\"UserName\\\"]"));

        //start -> //tag[starts-with(@attr,'startOfValue')]
        driver.findElement(By.xpath("//input[starts-with(@class,'ng-untouched')]"));
    }

    @Test
    public void findElementByXpath2() {
        //parent
        driver.findElement(By.xpath("//h1/parent::*"));// move up
        driver.findElement(By.xpath("//h1/.."));
        driver.findElement(By.xpath("//h1/parent::div"));

        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*"));// all
        driver.findElement(By.xpath("//h1/ancestor::div"));// two options
        driver.findElement(By.xpath("//h1/ancestor::div[2]"));// one option

        //following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::*"));// all
        driver.findElement(By.xpath("//h1/following-sibling::form"));// one option

        //preceding-sibling
        driver.findElement(By.xpath("//h2/preceding-sibling::*"));
    }
}

// css=div>span --> xpath=//div/span

//css=div span --> xpath=//div//span

//parent
//child
//ancestor
//descendant