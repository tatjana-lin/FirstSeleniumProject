package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest(){

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail("valid@email.com")
                .setPassword("ValidPass123$"));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isUsersEmailLinkPresent());
    }

}
