package com.superheroes.superheroes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superheroes.superheroes.entity.Superheroe;

@Repository
public interface RepositorySuperheroe extends JpaRepository<Superheroe, Long>{

}
