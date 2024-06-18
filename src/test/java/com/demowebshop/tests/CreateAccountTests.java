package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTests extends TestBase{

    @Test(enabled = false)
    public void createAccountPositiveTest(){

        int i = new Random().nextInt(1000) + 1000;
//        click on Register link
        click(By.cssSelector("[href='/register']"));
//        enter First name
        type(By.name("FirstName"), "Alice");
//        enter Last name
        type(By.name("LastName"), "Jackson");
//        enter email
        type(By.name("Email"), "valid" + i + "@email.com");
//         enter password
        type(By.name("Password"), "ValidPass123$");
//         confirm password
        type(By.name("ConfirmPassword"), "ValidPass123$");

//          click on Registration button
        click(By.name("register-button"));
//          assert Logout link is present
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }

    @Test
    public void createExistedAccountNegativeTest(){

        click(By.cssSelector("[href='/register']"));
        type(By.name("FirstName"), "Alice");
        type(By.name("LastName"), "Jackson");
        type(By.name("Email"), "valid@email.com");
        type(By.name("Password"), "ValidPass123$");
        type(By.name("ConfirmPassword"), "ValidPass123$");

        click(By.name("register-button"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".validation-summary-errors")));
    }
}
