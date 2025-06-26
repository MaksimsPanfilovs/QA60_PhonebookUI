package com_phonebook_test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        // click on Login link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.name("email"), "max3@gmail.com");

        // enter password
        type(By.name("password"), "Qwerty1!");

        // click on Registration button
        click(By.name("registration"));

        // verify Sign out button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        // click on Login link
        click(By.cssSelector("[href='/login']"));

        // enter email
        type(By.name("email"), "max3@gmail.com");

        // enter password
        type(By.name("password"), "Qwerty1!");

        // click on Registration button
        click(By.name("registration"));

        // verify alert is displayed
        Assert.assertTrue(isAlertDisplayed());
    }


}
