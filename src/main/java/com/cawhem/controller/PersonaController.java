package com.cawhem.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.cawhem.exception.ModeloNotFoundException;
import com.cawhem.model.Persona;
import com.cawhem.service.IPersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<Persona>> listarController() {
		List<Persona> lista = service.listarService();
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorIdController(@PathVariable("id") Integer id) {
		Persona obj = service.leerPorIdService(id);
		if (obj.getIdPersona() == null) {
			throw new ModeloNotFoundException("ID no encontrado " + id);
		}
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrarController(@Valid @RequestBody Persona objReq) {
		Persona obj = service.registrarService(objReq);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Persona> modificarController(@RequestBody Persona objReq) {
		Persona obj = service.modificarService(objReq);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarController(@PathVariable("id") Integer id) {
		Persona obj = service.leerPorIdService(id);
		if (obj.getIdPersona() == null) {
			throw new ModeloNotFoundException("ID no encontrado " + id);
		}
		service.eliminarService(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
