package com.theinternet.tests;

import com.theintermet.pages.DropdownListPage;
import com.theintermet.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownListTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getDropdownListPage();
    }

    @Test
    public void dropdownListTest(){
        new DropdownListPage(driver).selectOption(1)
                .verifyText();
    }

}
