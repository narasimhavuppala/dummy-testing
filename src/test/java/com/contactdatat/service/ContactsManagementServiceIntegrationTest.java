package com.contactdatat.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.contactdata.controller.ContactsManagementController;
import com.contactdata.domain.CustomerContact;
import com.contactdata.service.ContactsManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ContactsManagementController.class},webEnvironment = WebEnvironment.NONE)

public class ContactsManagementServiceIntegrationTest {
	
	@Autowired
	private ContactsManagementService contactsManagementService;
	
	
	@Test
	public void testAddContactHappyPath() {
		
		// Create a contact
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Jenny");
		aContact.setLastName("Johnson");
		
		
		// Test adding the contact
		CustomerContact newContact = contactsManagementService.add(aContact);
		
		
		// Verify the addition
		assertNotNull(newContact);
		assertNotNull(newContact.getId());
		assertEquals("Jenny", newContact.getFirstName());
		
	}
}
