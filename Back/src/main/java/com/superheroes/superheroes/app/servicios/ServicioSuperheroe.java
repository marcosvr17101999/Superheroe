package com.superheroes.superheroes.app.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superheroes.superheroes.app.entity.Superheroe;
import com.superheroes.superheroes.app.repository.RepositorySuperheroe;

@Service
public class ServicioSuperheroe {

	@Autowired
	private RepositorySuperheroe repositorioHeroe;
	
	//metodo para insertar un grupo de datos basico para poder probar
	public List<Superheroe> insertarDatos(){
		Superheroe heroe1=new Superheroe("Spiderman","Arañas");
		Superheroe heroe2=new Superheroe("Batman","Dinero");
		Superheroe heroe3=new Superheroe("Lobezno","Garras");
		List<Superheroe> lista =new ArrayList<Superheroe>() ;
		lista.add(heroe3);;
		lista.add(heroe2);
		lista.add(heroe1);
		return repositorioHeroe.saveAll(lista);
	}
	
	//metodo para insertar un nuevo superheroe
	public Superheroe guardarSuperhereo(Superheroe heroe) {
		// TODO Auto-generated method stub
		return repositorioHeroe.save(heroe);
	}

	//metodo para obtener por el id el objeto superheroe
	public Superheroe obtenerSuperheroe(Long id) {
		// TODO Auto-generated method stub
		return repositorioHeroe.findById(id).orElseThrow(()-> {throw new RuntimeException();});
	}

	//metodo para editar un superheroe pasando el id y un nuevo objeto de tipo superheroe
	public Superheroe editarSuperheroe(Long id, Superheroe edicionHeroe) {
		// TODO Auto-generated method stub
		Superheroe heroe = repositorioHeroe.findById(id).get();
		heroe.setNombre(edicionHeroe.getNombre());
		heroe.setPoder(edicionHeroe.getPoder());
		return repositorioHeroe.save(heroe);
	}

	//metodo para eliminar un superheroe por su id
	public boolean eliminarSuperheroe(Long id) {
		// TODO Auto-generated method stub
		try {
			repositorioHeroe.deleteById(id);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	//metodo que te devuelve un listado de todos los superheroes
	public List<Superheroe> findAll(){
		return repositorioHeroe.findAll();
	}
	
	//metodo para encontrar el heroe o el listado de heroes que contenga los caracteres introducidos
	public List<Superheroe> findByNombre(String string){
		return repositorioHeroe.findByNombreContainingIgnoreCase(string);
	}
}
