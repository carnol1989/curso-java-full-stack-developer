package com.cawhem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cawhem.model.Persona;
import com.cawhem.repo.IPersonaRepo;
import com.cawhem.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaRepo repo;
	
	@Override
	public Persona registrarService(Persona obj) {
		return repo.save(obj);
	}

	@Override
	public Persona modificarService(Persona obj) {
		return repo.save(obj);
	}

	@Override
	public List<Persona> listarService() {
		return repo.findAll();
	}

	@Override
	public Persona leerPorIdService(Integer id) {
		Optional<Persona> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Persona();
	}

	@Override
	public boolean eliminarService(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
