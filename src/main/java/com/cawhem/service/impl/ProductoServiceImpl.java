package com.cawhem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cawhem.model.Producto;
import com.cawhem.repo.IProductoRepo;
import com.cawhem.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo repo;

	@Override
	public Producto registrarService(Producto obj) {
		return repo.save(obj);
	}

	@Override
	public Producto modificarService(Producto obj) {
		return repo.save(obj);
	}

	@Override
	public List<Producto> listarService() {
		return repo.findAll();
	}

	@Override
	public Producto leerPorIdService(Integer id) {
		Optional<Producto> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Producto();
	}

	@Override
	public boolean eliminarService(Integer id) {
		repo.deleteById(id);
		return true;
	}
	
}
