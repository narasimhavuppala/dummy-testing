package com.contactdatat.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.contactdata.Application;
import com.contactdata.domain.CustomerContact;
import com.contactdata.service.ContactsManagementService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes = Application.class)
public class MyServiceIntegrationTest {

	@Autowired
	ContactsManagementService service;

	@Test
	public void testPaths() {
		CustomerContact aContact = new CustomerContact();
		aContact.setFirstName("Narasimha");
		CustomerContact ret = service.add(aContact);
		assertNotNull(ret);
		System.out.println(ret.getFirstName());
		
	}

}
