package com.crud_example.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud_example.exception.ModeloNotFoundException;
import com.crud_example.model.Person;
import com.crud_example.service.IPersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private IPersonService service;
	
	@GetMapping
	public ResponseEntity<List<Person>> listar() throws Exception{
		List<Person> lista= service.listar();
		return new ResponseEntity<List<Person>>(lista,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Person obj= service.listarPorId(id);
		return new ResponseEntity<Person>(obj,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Person> registrar(@RequestBody Person person) throws Exception{
		Person obj= service.registrar(person);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping 
	public ResponseEntity<Person> actualizar(@RequestBody Person person) throws Exception{
		Person obj = service.actualizar(person);
		return new ResponseEntity<Person>(obj,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Person obj= service.listarPorId(id);
			if(obj == null) {
				throw new  ModeloNotFoundException("ID NO ENCONTRADO " + id);
			}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
