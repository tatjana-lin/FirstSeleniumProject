package com.demowebshop.tests;

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
                .setEmail("valid@email.com")
                .setPassword("ValidPass123$"));
        app.getUser().clickOnLoginButton();
        app.getUser().pause(1000);
    }

    @Test(enabled = false)
    public void addItemToCartTest(){

        app.getCart().clickOnAddToCartButton();
        app.getUser().pause(1000);
        app.getCart().clickOnShoppingCartLink();
        app.getUser().pause(1000);
//        Assert.assertTrue(app.getCart().isProductAddedToCart());
        Assert.assertTrue(app.getCart().isProductAddedToCart1());
    }

    @AfterMethod
    public void postCondition() {
        app.getCart().removeProductFromCart();
    }
}


