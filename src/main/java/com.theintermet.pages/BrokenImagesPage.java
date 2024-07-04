package com.theintermet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class BrokenImagesPage extends BasePage {
    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img")
    List<WebElement> images;

    public BrokenImagesPage checkAllImages() {
        System.out.println("Total number of images on the web page:  " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);
            checkImageSizeWithJS(image);
        }
        return this;
    }

    @FindBy(css = "img:nth-child(2)")
    WebElement image1;
    @FindBy(css = "img:nth-child(3)")
    WebElement image2;
    @FindBy(css = "img:nth-child(4)")
    WebElement image3;

    public BrokenImagesPage checkIsImageBroken(int imageNumber) {
        Assert.assertEquals(checkImageSizeWithJS(image1), "BROKEN");
        return this;
    }
}
