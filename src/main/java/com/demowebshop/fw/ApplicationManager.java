package com.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    String browser;
    WebDriver driver;

    UserHelper user;
    HomePageHelper homePage;
    AddToCartHelper cart;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        System.err.close();

        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

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
