package com.theinternet.tests;

import com.theintermet.pages.FileUploadPage;
import com.theintermet.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getFileUploadPage();
    }

    @Test
    public void fileUploadTest(){
        new FileUploadPage(driver).uploadFileWithRobot().pressSubmitButton()
                .verifyMessage("File Uploaded!");

    }


}
