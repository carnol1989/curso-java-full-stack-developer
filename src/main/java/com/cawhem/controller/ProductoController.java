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
import com.cawhem.model.Producto;
import com.cawhem.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService service;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listarController() {
		List<Producto> lista = service.listarService();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorIdController(@PathVariable("id") Integer id) {
		Producto obj = service.leerPorIdService(id);
		if (obj.getIdProducto() == null) {
			throw new ModeloNotFoundException("ID no encontrado " + id);
		}
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrarController(@Valid @RequestBody Producto objReq) {
		Producto obj = service.registrarService(objReq);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Producto> modificarController(@RequestBody Producto objReq) {
		Producto obj = service.modificarService(objReq);
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarController(@PathVariable("id") Integer id) {
		Producto obj = service.leerPorIdService(id);
		if (obj.getIdProducto() == null) {
			throw new ModeloNotFoundException("ID no encontrado " + id);
		}
		service.eliminarService(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
