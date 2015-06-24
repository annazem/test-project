package com.example.tests;

import org.testng.annotations.Test;

public class ContactsCreationTests extends TestBase {

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMaimPage();
	gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header1 1";
    group.footer = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMaimPage();
	gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
  
}
