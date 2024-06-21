package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest{

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp(){
     driver = new ChromeDriver();
     driver.get("https://www.google.com");

     driver.navigate().to("https://www.google.com"); //with history

        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    //tests

    @Test
    public void openGoogle(){
        System.out.println("Google opened!");
    }
    //after - tearDown
    @AfterMethod(enabled = false)
    public void tearDown(){
        //interview question
        driver.quit(); //close all tabs & browser
//        driver.close(); //close only one tab ( if only one tab -> close browser)
    }
}
