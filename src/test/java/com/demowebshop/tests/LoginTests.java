package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest(){
        //click on login link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("Email"), "valid@email.com");
//    enter password
        type(By.name("Password"), "ValidPass123$");
//        click on Login button
        click(By.cssSelector(".button-1.login-button"));
//        assert Log out button is present
//        Assert.assertTrue(isElementPresent(By.cssSelector("")));
//        Assert customer info is present
        Assert.assertTrue(isTextPresent(By.cssSelector(".header-links-wrapper:nth-child(2) [href='/customer/info']"), "valid@email.com"));
    }
}
