package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test
    public void loginPositiveTest(){

        logger.info("Users login data: " + UserData.EMAIL + " --- " + UserData.PASSWORD);

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isUsersEmailLinkPresent());
    }

    @Test
    public void loginWithInvalidEmailNegativeTest(){
        logger.info("Users data: invalidemail.com --- " + UserData.PASSWORD);

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail("invalidemail.com")
                .setPassword(UserData.PASSWORD)
                );
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isErrorEnterValidEmailPresent());

        app.getUser().clearLoginForm();
    }
}


