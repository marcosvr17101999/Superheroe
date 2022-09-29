package com.superheroes.superheroes.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.superheroes.superheroes.app.entity.Superheroe;
import com.superheroes.superheroes.app.servicios.ServicioSuperheroe;

@CrossOrigin(origins="*")
@RequestMapping("/superheroe")
@RestController
public class ControladorSuperheroe {
	
	@Autowired
	private ServicioSuperheroe servicioSuperheroe;
	
	@PostMapping
	public ResponseEntity<Superheroe> guardarSuperheroe(@RequestBody Superheroe heroe) {
		return new ResponseEntity<Superheroe>(servicioSuperheroe.guardarSuperhereo(heroe),HttpStatus.CREATED);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Superheroe> getSuperheroe(@PathVariable("id") Long id) {
		return new ResponseEntity<Superheroe>(servicioSuperheroe.obtenerSuperheroe(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Superheroe> modificarSuperheroe(@PathVariable("id") Long id,@RequestBody Superheroe heroe) {
		return new ResponseEntity<Superheroe>(servicioSuperheroe.editarSuperheroe(id,heroe),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> eliminarSuperheroe(@PathVariable("id") Long id) {
		boolean eliminado = servicioSuperheroe.eliminarSuperheroe(id);
		if(eliminado) {
			return new ResponseEntity<Object>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/all")
	public ResponseEntity<List<Superheroe>> listAll(){
		return new ResponseEntity<List<Superheroe>>(servicioSuperheroe.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/findByNombre/{string}")
	public ResponseEntity<List<Superheroe>> listSearchByNombre(@PathVariable("string") String string){
		return new ResponseEntity<List<Superheroe>>(servicioSuperheroe.findByNombre(string),HttpStatus.OK);
	} 
}