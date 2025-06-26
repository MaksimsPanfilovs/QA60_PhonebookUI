package com_phonebook_test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginPositiveTest(){
        // click on Login link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.name("email"), "max3@gmail.com");

        // enter password
        type(By.name("password"), "Qwerty1!");

        // click on Login button
        click(By.name("login"));

        // verify Sign out button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

}
