package com.cawhem.service;

import java.util.List;

public interface ICRUD<T> {

	T registrarService(T obj);

	T modificarService(T obj);

	List<T> listarService();

	T leerPorIdService(Integer id);

	boolean eliminarService(Integer id);

}
