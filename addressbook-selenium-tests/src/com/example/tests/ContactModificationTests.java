package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
	 @Test
	  public void modifySomeContact() {
		app.getNavigationHelper().openMaimPage();
		app.getContactHelper().initContactModification(1);
		ContacnData contact = new ContacnData();
		contact.fname = "new name";
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnContactPage();
	  }

}
