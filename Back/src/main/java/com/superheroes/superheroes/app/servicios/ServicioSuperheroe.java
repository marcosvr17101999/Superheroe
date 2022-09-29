package com.superheroes.superheroes.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superheroes.superheroes.app.entity.Superheroe;
import com.superheroes.superheroes.app.repository.RepositorySuperheroe;

@Service
public class ServicioSuperheroe {

	@Autowired
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
	
	public List<Superheroe> findAll(){
		return repositorioHeroe.findAll();
	}
	
	public List<Superheroe> findByNombre(String string){
		return repositorioHeroe.findByNombreContainingIgnoreCase(string);
	}
}
