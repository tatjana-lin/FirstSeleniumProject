package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
                .setFirstName("Alice").setLastName("Jackson")
                .setEmail("valid@email.com")
                .setPassword("ValidPass123$"));
        app.getUser().clickOnRegisterButton();

        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }

    @Test
    public void createExistedAccountNegativeTest(){
        
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setFirstName("Alice").setLastName("Jackson")
                .setEmail("valid@email.com")
                .setPassword("ValidPass123$"));
        app.getUser().clickOnRegisterButton();
        
        Assert.assertTrue(app.getUser().isErrorEmailAlreadyExistsPresent());
    }

}
