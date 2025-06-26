package com_phonebook_test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @Test
    public void isHomeComponentPresentTest() {
//        driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
//        System.out.println("Home Component " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div>h1")).size() > 0;
    }
}
