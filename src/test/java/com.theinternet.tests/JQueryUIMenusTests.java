package com.theinternet.tests;

import com.theintermet.pages.HomePage;
import com.theintermet.pages.JQueryUIMenusPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JQueryUIMenusTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getJQueryUIMenusPage();
    }

    @Test
    public void backToJqueryUITest(){
        new JQueryUIMenusPage(driver).selectBackToJQuery()
                .verifyText("is many things, but one thing");

    }

    @Test
    public void downloadCsvFileTest(){
        new JQueryUIMenusPage(driver).selectDownloadsCsvFile()
                .verifyFilePath("C:/Users/Tanya/Downloads");
    }

}
