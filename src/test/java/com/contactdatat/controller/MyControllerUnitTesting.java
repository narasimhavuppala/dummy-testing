package com.contactdatat.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.contactdata.Application;
import com.contactdata.controller.ContactsManagementController;
import com.contactdata.domain.CustomerContact;
import com.contactdata.service.ContactsManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
@ContextConfiguration(classes = Application.class)
public class MyControllerUnitTesting {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ContactsManagementService service;

	@Test
	public void addContact() throws Exception {

		CustomerContact contact = new CustomerContact();
		contact.setFirstName("Narasimha");
		when(service.add(any(CustomerContact.class))).thenReturn(contact);
		// when(service.add(any(CustomerContact.class))).thenReturn(contact);

		mvc.perform(post("/addContact").content(asJsonString(contact)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.0").value("success"));

	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
