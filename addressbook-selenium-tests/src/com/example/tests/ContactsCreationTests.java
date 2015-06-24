package com.example.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMaimPage();
	gotoContactsPage();
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
	fillContactForm(contact);
    submitContactCreation();
    returnContactPage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMaimPage();
	gotoContactsPage();
	fillContactForm(new ContacnData("", "", "", "", "", "", "", "", "", "", ""));
    submitContactCreation();
    returnContactPage();
  }
  
private void returnContactPage() {
    driver.findElement(By.linkText("home page")).click();
}

private void submitContactCreation() {
    driver.findElement(By.name("submit")).click();
}

private void fillContactForm(ContacnData contact) {
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contact.fname);
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contact.lname);
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(contact.address1);
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(contact.hnumber);
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(contact.mnumber);
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(contact.wnumber);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contact.mail1);
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(contact.mail2);
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(contact.year);
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(contact.address2);
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(contact.phonenumber);
}

private void gotoContactsPage() {
	driver.findElement(By.linkText("add new")).click();
}

}