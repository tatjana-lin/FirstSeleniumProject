package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartHelper extends BaseHelper {
    public AddToCartHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isProductAddedToCart() {
        return isElementPresent(By.xpath("//td//a[.='14.1-inch Laptop']"));
    }

    public boolean isProductAddedToCart1() {
        return isTextPresent(By.cssSelector(".cart-item-row .product>a"), "14.1-inch Laptop");
    }

    public void clickOnShoppingCartLink() {
        click(By.cssSelector("#topcartlink>a"));
    }

    public void clickOnAddToCartButton() {
        click(By.cssSelector(".item-box:nth-child(3) .buttons>input"));
    }

    public void removeProductFromCart() {
        click(By.name("removefromcart"));
        click(By.name("updatecart"));
    }
}
