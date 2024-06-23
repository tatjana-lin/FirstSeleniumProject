package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import com.demowebshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test(enabled = false)
    public void createAccountPositiveTest(){
//        int i = new Random().nextInt(1000) + 1000;
//        type(By.name("Email"), "valid" + i + "@email.com");

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName(UserData.FIRST_NAME).setLastName(UserData.LAST_NAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @Test
    public void createExistedAccountNegativeTest(){
        
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName(UserData.FIRST_NAME).setLastName(UserData.LAST_NAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegisterButton();
        
        Assert.assertTrue(app.getUser().isErrorEmailAlreadyExistsPresent());
    }



    @Test(dataProvider = "createAccountWithCsv", dataProviderClass = DataProviders.class)
       public void createAccountPositiveTestFromDataProviderWithCsv(User user){

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

}
