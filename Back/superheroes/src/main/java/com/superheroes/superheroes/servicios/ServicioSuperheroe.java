package com.superheroes.superheroes.servicios;

import java.util.Optional;

import com.superheroes.superheroes.entity.Superheroe;
import com.superheroes.superheroes.repository.RepositorySuperheroe;

public class ServicioSuperheroe{

	
	private RepositorySuperheroe repositorioHeroe;
	
	
	public Superheroe guardarSuperhereo(Superheroe heroe) {
		// TODO Auto-generated method stub
		return repositorioHeroe.save(heroe);
	}

	public Superheroe obtenerSuperheroe(Long id) {
		// TODO Auto-generated method stub
		return repositorioHeroe.findById(id).orElseThrow(()-> {throw new RuntimeException();});
	}

	public Superheroe editarSuperheroe(Long id, Superheroe edicionHeroe) {
		// TODO Auto-generated method stub
		Superheroe heroe = repositorioHeroe.findById(id).get();
		heroe.setNombre(edicionHeroe.getNombre());
		heroe.setPoder(edicionHeroe.getPoder());
		return repositorioHeroe.save(heroe);
	}

	public boolean eliminarSuperheroe(Long id) {
		// TODO Auto-generated method stub
		try {
			repositorioHeroe.deleteById(id);
			return true;
		}catch(Exception e){
			
			return false;
		}
	}
}
