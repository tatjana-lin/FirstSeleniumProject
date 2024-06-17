package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test(enabled = false)
    public void createAccountPositiveTest(){
//    click on Register link
//    enter First name
//    enter Last name
//    enter email
//    enter password
//    confirm password
//    click on the registration button
//    assert customer/info is present

        //click on Register link
        click(By.cssSelector(".ico-register"));
//        enter First name
        type(By.name("FirstName"), "Alice");
//        enter Last name
        type(By.name("LastName"), "Jackson");
//        enter email
        type(By.name("Email"), "valid@email.com");
//         enter password
        type(By.name("Password"), "ValidPass123$");
//         confirm password
        type(By.name("ConfirmPassword"), "ValidPass123$");

//          click on Registration button
        click(By.name("register-button"));
//          assert customer/info is present
        Assert.assertTrue(isElementPresent(By.xpath("//a[.='valid@email.com']")));

    }

}
