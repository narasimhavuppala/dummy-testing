package com.contactdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactdata.domain.CustomerContact;
import com.contactdata.repos.CustomerContactRepository;

@Service
public class ContactsManagementService {

	@Autowired
	private CustomerContactRepository customerContactRepository;
	
	public CustomerContact add(CustomerContact aContact) {
		
		CustomerContact newContact = null;
		
		if (aContact.getFirstName() != null) {
			newContact =  customerContactRepository.save(aContact);
		}
		
		return newContact;	
	}
	
	/*
	public CustomerContact addContactOccasion(CustomerContact aContact, ContactImportantOccasion anOccasion) {
		CustomerContact newContact = null;
		
		return newContact;	
	}
	*/
}
