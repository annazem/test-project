package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMaimPage();
	
	// save old state
	List<ContacnData> oldList = app.getContactHelper().getContacts();
	
	// actions
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
    
    // save new state
    List<ContacnData> newList = app.getContactHelper().getContacts();
    
    // compare states
    assertEquals(newList.size(), oldList.size() +1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getContactHelper().gotoContactsPage();
	app.getContactHelper().fillContactForm(new ContacnData("", "", "", "", "", "", "", "", "", "", ""));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnContactPage();
  }
  


}