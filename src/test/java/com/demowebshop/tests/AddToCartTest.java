package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
//    enter email
        type(By.name("Email"), "valid@email.com");
//    enter password
        type(By.name("Password"), "ValidPass123$");
//        click on Login button
        click(By.xpath("//input[@value='Log in']"));
    }

    @Test
    public void addItemToCartTest(){
        click((By.xpath("//div[@class='product-grid home-page-product-grid']/div[3]/div/div[2]/div[3]/div[2]/input")));
        click(By.xpath("//span[.='Shopping cart']"));
        Assert.assertTrue(isElementPresent(By.xpath("//td[3]/a[.='14.1-inch Laptop']")));

//        //a[@class='product-name']
//        //table[@class='cart']//td[3]/a[.='14.1-inch Laptop']
//        //td[3]/a[.='14.1-inch Laptop']
//        css -> tr:nth-child(1)>td:nth-child(3)>a
//        css -> td:nth-child(3)>a
    }
}


