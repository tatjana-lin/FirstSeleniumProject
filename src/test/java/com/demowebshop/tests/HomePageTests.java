package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}

