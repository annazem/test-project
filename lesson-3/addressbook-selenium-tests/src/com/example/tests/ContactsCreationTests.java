package com.example.tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Test public class ContactsCreationTests extends TestBase {

  public void testNonEmptyContactCreation(ContacnData contact) throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getContactHelper().gotoContactsPage();
	//ContacnData contact = new ContacnData();
	List<ContacnData> oldList1 = app.getContactHelper().getContacts();
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
    
    List<ContacnData> newList = app.getContactHelper().getContacts();
    oldList1.add(contact);
    Collections.sort(oldList1);
    AssertJUnit.assertEquals(newList, oldList1);
  }
  
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMaimPage();
	app.getContactHelper().gotoContactsPage();
	app.getContactHelper().fillContactForm(new ContacnData("", "", "", "", "", "", "", "", "", "", ""));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnContactPage();
  }
  


}