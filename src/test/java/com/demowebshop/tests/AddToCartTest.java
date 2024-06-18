package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.name("Email"), "valid@email.com");
        type(By.name("Password"), "ValidPass123$");
        click(By.cssSelector(".button-1.login-button"));
    }

    @Test
    public void addItemToCartTest(){
//        click on the AddToCart button
        click((By.cssSelector(".item-box:nth-child(3) .buttons")));
//        click on the Shopping cart link
        click(By.id("topcartlink"));

//        Assert.assertTrue(isElementPresent(By.xpath("//td[3]/a[.='14.1-inch Laptop']")));
        Assert.assertTrue(isTextPresent(By.cssSelector(".cart-item-row .product>a"), "14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition() {
        //click on Card
        click(By.name("removefromcart"));
        //click on Remove button
        click(By.name("updatecart"));
    }
}


