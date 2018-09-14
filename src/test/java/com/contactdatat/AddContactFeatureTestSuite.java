package com.contactdatat;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.contactdatat.controller.ContactsManagementControllerIntegrationTest;
import com.contactdatat.repos.CustomerContactRepositoryIntegrationTest;
import com.contactdatat.service.ContactsManagementServiceIntegrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses ({ContactsManagementServiceIntegrationTest.class, ContactsManagementControllerIntegrationTest.class, CustomerContactRepositoryIntegrationTest.class})
public class AddContactFeatureTestSuite {

	// intentionally empty - Test Suite Setup (annotations) is sufficient
}
