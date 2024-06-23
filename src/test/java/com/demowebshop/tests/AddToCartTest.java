package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutLink();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getUser().pause(1000);
    }

    @Test(enabled = true)
    public void addItemToCartTest(){

        app.getCart().clickOnAddToCartButton();
        app.getCart().clickOnShoppingCartLink();

        Assert.assertTrue(app.getCart().isProductAddedToCart());
    }

    @AfterMethod
    public void postCondition() {
        app.getCart().removeProductFromCart();
    }
}


