package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.TestBase;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMaimPage() {
	   driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void gotoGroupsPage() {
		click(By.linkText("groups"));
	}

}
