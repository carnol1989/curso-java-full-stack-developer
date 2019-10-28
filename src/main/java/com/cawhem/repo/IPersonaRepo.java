package com.cawhem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cawhem.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
