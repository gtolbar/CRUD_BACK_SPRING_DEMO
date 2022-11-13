package com.crud_example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_example.model.Person;
import com.crud_example.repository.IGenericRepository;
import com.crud_example.repository.IPersonRepository;
import com.crud_example.service.IPersonService;

@Service
public class PersonServiceImpl extends CRUDImpl<Person, Integer> implements IPersonService{
	
	@Autowired
	private IPersonRepository repo;
	
	@Override
	protected IGenericRepository<Person, Integer> getRepo() {
		return repo;
	}

}
