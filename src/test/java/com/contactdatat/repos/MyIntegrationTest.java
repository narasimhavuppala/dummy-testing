package com.contactdatat.repos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.contactdata.domain.CustomerContact;
import com.contactdata.repos.CustomerContactRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class MyIntegrationTest {

	@Autowired
	TestEntityManager em;

	@Autowired
	private CustomerContactRepository customerContactRepository;

	@Test()
	void testEx() {

		CustomerContact entity = new CustomerContact();
		entity.setId(2L);
		CustomerContact ret = em.persist(entity);
		em.flush();
		assertThat(ret).isNotNull();
	}

}
