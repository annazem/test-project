package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContacnData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void gotoContactsPage() {
		click(By.linkText("add new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContacnData contact) {
		type(By.name("firstname"), contact.fname);
		type(By.name("lastname"), contact.lname);
		type(By.name("address"), contact.address1);
		type(By.name("home"), contact.hnumber);
		type(By.name("mobile"), contact.mnumber);
		type(By.name("work"), contact.wnumber);
		type(By.name("email"), contact.mail1);
		type(By.name("email2"), contact.mail2);
		type(By.name("byear"), contact.year);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phonenumber);
	    
	}

	public void returnContactPage() {
		click(By.linkText("home page"));
	}

	public void deleteContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("(//input[@name='update'])[2]"));
		
	}

	private void selectContactByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])["+ index +"]"));
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);
	}
	

	public void submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));
		
	}

	
}
