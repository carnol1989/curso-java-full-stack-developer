package com.cawhem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cawhem.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Integer> {

}
