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

public class TableTests{

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void tableCssTest() {
        //get row 8, last element
        WebElement canada = driver.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
        System.out.println(canada.getText());
        System.out.println("==================================================");

        //get row 1
        WebElement row1 = driver.findElement(By.cssSelector("tr:nth-child(1)"));
        System.out.println(row1.getText());
        System.out.println("==================================================");

        //get numbers of row
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        for (WebElement el: rows) {
            System.out.println(el.getText());
        }
        System.out.println("==================================================");
        for (int i = 0; i <rows.size(); i++) {
            System.out.println(rows.get(i).getText());
        }
    }
}

//     tag1#id tag2   --> //tag1[@id='id']//tag2
//     tag1#id>tag2  --> //tag1[@id='id']/tag2
//     tag1#id>tag2:nth-child(2) --> //tag1[@id='id']/tag2[2]
//   tag1#id>tag2:last-child  -->  //tag1[@id='id']/tag2[last()]
