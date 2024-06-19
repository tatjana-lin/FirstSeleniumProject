package com.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {
    WebDriver driver;

    UserHelper user;
    HomePageHelper homePage;
    AddToCartHelper cart;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        homePage = new HomePageHelper(driver);
        cart = new AddToCartHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public AddToCartHelper getCart() {
        return cart;
    }

    public void stop() {
        driver.quit();
    }

}
