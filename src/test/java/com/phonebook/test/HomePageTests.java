package com.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getHome().isHomeComponentPresent()) {
            app.getHome().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest() {
//        driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
//        System.out.println("Home Component " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
        return app.getHome().isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }
}
