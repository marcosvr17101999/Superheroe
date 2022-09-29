package com.superheroes.superheroes.controlador;

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

import com.superheroes.superheroes.entity.Superheroe;
import com.superheroes.superheroes.servicios.ServicioSuperheroe;

@CrossOrigin(origins="*")
@RequestMapping("/superheroe")
@RestController
public class ControladorSuperheroe {
	
	private ServicioSuperheroe servicioSuperheroe;
	
	@PostMapping
	public ResponseEntity guardarSuperheroe(@RequestBody Superheroe heroe) {
		return new ResponseEntity(servicioSuperheroe.guardarSuperhereo(heroe),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getSuperheroe(@PathVariable("id") Long id) {
		return new ResponseEntity(servicioSuperheroe.obtenerSuperheroe(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity modificarSuperheroe(@PathVariable("id") Long id,@RequestBody Superheroe heroe) {
		return new ResponseEntity(servicioSuperheroe.editarSuperheroe(id,heroe),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity eliminarSuperheroe(@PathVariable("id") Long id) {
		boolean eliminado = servicioSuperheroe.eliminarSuperheroe(id);
		if(eliminado) {
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		
	}
}