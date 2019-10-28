package com.cawhem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cawhem.model.Venta;
import com.cawhem.repo.IVentaRepo;
import com.cawhem.service.IVentaService;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaRepo repo;
	
	@Override
	public Venta registrarService(Venta obj) {
		obj.getDetalleVenta().forEach(det -> {
			det.setVenta(obj);
		});
		return repo.save(obj);
	}

	@Override
	public Venta modificarService(Venta obj) {
		return repo.save(obj);
	}

	@Override
	public List<Venta> listarService() {
		return repo.findAll();
	}

	@Override
	public Venta leerPorIdService(Integer id) {
		Optional<Venta> op = repo.findById(id);		
		return op.isPresent() ? op.get() : new Venta();
	}

	@Override
	public boolean eliminarService(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
