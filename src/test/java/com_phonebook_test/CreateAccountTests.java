package com_phonebook_test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

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

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
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

    public boolean isAlertDisplayed() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }


}
