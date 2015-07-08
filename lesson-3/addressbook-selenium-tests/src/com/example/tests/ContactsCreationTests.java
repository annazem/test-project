package com.example.tests;

import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getContactHelper().gotoContactsPage();
	ContacnData contact = new ContacnData();
	contact.fname = "Anna";
	contact.lname = "Zemskova";
	contact.address1 = "Address 1";
	contact.hnumber = "123";
	contact.mnumber = "321";
	contact.wnumber = "456";
	contact.mail1 = "email1@mail.ru";
	contact.mail2 = "email2@mail.ru";
	contact.year = "1990";
	contact.address2 = "Address 2";
	contact.phonenumber = "987654321";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnContactPage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getContactHelper().gotoContactsPage();
	app.getContactHelper().fillContactForm(new ContacnData("", "", "", "", "", "", "", "", "", "", ""));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnContactPage();
  }
  


}