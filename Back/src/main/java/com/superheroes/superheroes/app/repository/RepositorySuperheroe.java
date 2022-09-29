package com.superheroes.superheroes.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superheroes.superheroes.app.entity.Superheroe;


@Repository
public interface RepositorySuperheroe extends JpaRepository<Superheroe, Long>{

	//CONSULTA JPA QUE DEVUELVE UNA LISTA DE SUPERHEROES QUE CONTENGA EL STRING IGNORANDO MAYUSCULAS Y MINUSCULAS
	public List<Superheroe> findByNombreContainingIgnoreCase(String string);
}
