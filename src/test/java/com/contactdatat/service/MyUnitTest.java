package com.contactdatat.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import com.contactdata.Application;
import com.contactdata.domain.CustomerContact;
import com.contactdata.repos.CustomerContactRepository;
import com.contactdata.service.ContactsManagementService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@ContextConfiguration(classes = Application.class)
public class MyUnitTest {

	@InjectMocks
	ContactsManagementService service;

	@Mock
	CustomerContactRepository customerContactRepository;

	@Test
	public void testMocks() {
		System.out.println(service);
		System.out.println(customerContactRepository);
		CustomerContact aContact = new CustomerContact();
		aContact.setId(2L);
		CustomerContact nc = service.add(aContact);
		assertNull(nc);
		aContact.setFirstName("Narasimha");
		
		when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(aContact);
		
		nc = service.add(aContact);
		assertNotNull(nc.getFirstName());

	}

}
