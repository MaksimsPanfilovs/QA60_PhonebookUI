package com.phonebook.test;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    // precondition
    // login
    //add contact
    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("max3@gmail.com").setPassword("Qwerty1!"));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Karl")
                .setLastName("Tomash")
                .setPhone("1234567890")
                .setEmail("Karl@gmail.com")
                .setAddress("Berlin")
                .setDescription("QA"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactTest() {
        int sizeBefore = sizeOfContacts();
        // click on cart
        app.getContact().clickOnCart();
        // click on Remove button
        app.getContact().clickOnRemoveButton();
        app.getContact().pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);

    }

    public int sizeOfContacts() {
        // verify contact is deleted (by size)
        if (app.getContact().isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return app.driver.findElements
                    (By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }


}
