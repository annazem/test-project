package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;


public class ContactHelper extends HelperBase {
public static boolean CREATION = true;
public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
		 }


	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();  
		manager.navigateTo().mainPage();
		List<WebElement> contactRows = driver.findElements(By.xpath("//tr[@name='entry']"));  
				for (WebElement contactRow : contactRows) {  
		 				String fname = contactRow.findElement(By.xpath("./td[3]")).getText();  
		 				String lname = contactRow.findElement(By.xpath("./td[2]")).getText();  
		 				String mail1 = contactRow.findElement(By.xpath("./td[4]")).getText();  
		 				String hnumber = contactRow.findElement(By.xpath("./td[5]")).getText();  
		 				cachedContacts.add((ContactData) new ContactData().withFname(fname));  
		 			}  
	}


	public ContactHelper createContact(ContactData contact) {
		initContactsCreation();
		fillContactForm(contact, CREATION);
	    submitContactCreation();
	    returnContactPage();
	    rebuildCache();
	    return this;
	}  
	
	public ContactHelper deleteContact(int index) {
		selectContactByIndex(index);
		submitContactDeletion();
		returnContactPage();
		rebuildCache();
		return this;
	}

	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
		fillContactForm(contact, MODIFICATION);
	    submitContactModification();
	    returnContactPage();
	    rebuildCache();
		return this;
	}

	//---------------------------------------------------------------------------------------------------
	
	public ContactHelper initContactsCreation() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFname());
		type(By.name("lastname"), contact.getLname());
		type(By.name("address"), contact.getAddress1());
		type(By.name("home"), contact.getHnumber());
		type(By.name("mobile"), contact.getMnumber());
		type(By.name("work"), contact.getWnumber());
		type(By.name("email"), contact.getMail1());
		type(By.name("email2"), contact.getMail2());
		type(By.name("byear"), contact.getYear());
		if (formType == CREATION){
		} else {
			if (driver.findElements(By.name("new_group")).size() !=0){
				throw new Error("Group selector exists in contact modification form");
			}
		}
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhonenumber());
		return this; 
	}

	public ContactHelper returnContactPage() {
		click(By.linkText("home page"));
		return this;
	}



	private void selectContactByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])["+ index +"]"));
	}

	public ContactHelper initContactModification(int index) {
		selectContactByIndex(index);
		return this;
	}
	

	public ContactHelper submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));
		cachedContacts = null;
		return this;
	}

	private void submitContactDeletion() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
	}

	
}

