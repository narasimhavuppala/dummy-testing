package com.contactdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactdata.domain.CustomerContact;
import com.contactdata.service.ContactsManagementService;

@RestController
@RequestMapping("/api")
public class ContactDemoController {
	
	@Autowired
	ContactsManagementService service;
	
	@GetMapping("/{id}")
	public CustomerContact getContact(@PathVariable("id") Long id) {
		
		CustomerContact obj=new CustomerContact();
		obj.setFirstName("Test");
		
		return obj ;
	}

}
