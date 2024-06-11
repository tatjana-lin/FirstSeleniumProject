package com.ait.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoWebShopTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

    }

    @Test
    public void openDemoWebShop(){
        System.out.println("DemoWebShop opened!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        System.out.println("DemoWebShop closed!");

    }

}
