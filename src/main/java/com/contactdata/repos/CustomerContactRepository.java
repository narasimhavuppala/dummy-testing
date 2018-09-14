package com.contactdata.repos;

import org.springframework.data.repository.CrudRepository;

import com.contactdata.domain.CustomerContact;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

	public CustomerContact findByEmail(String email);
}
