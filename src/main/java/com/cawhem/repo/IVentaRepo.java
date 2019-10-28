package com.cawhem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cawhem.model.Venta;

public interface IVentaRepo extends JpaRepository<Venta, Integer> {

}
