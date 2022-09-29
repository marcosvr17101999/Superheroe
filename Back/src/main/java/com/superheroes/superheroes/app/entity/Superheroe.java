package com.superheroes.superheroes.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Superheroe {
	
	//ID SUPERHEROE QUE SE GENERA AUTOMATICAMENTE EN LA BASE DE DATOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//NOMBRE DESCRIPCION QUE TIENE EL OBJETO SUPERHEROE
	private String nombre;
	//INFORMACION ADICIONAL PARA EL OBJETO EN ESTE CASO PODER
	private String poder;
	
	
	//CONSTRUCTOR SIN PARAMENTROS
	public Superheroe() {
		super();
	}
	//CONSTRUCTOR DOS PARAMENTROS 
	public Superheroe(String nombre, String poder) {
		super();
		this.nombre = nombre;
		this.poder = poder;
	}
	/*GETTER & SETTER*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPoder() {
		return poder;
	}
	public void setPoder(String poder) {
		this.poder = poder;
	}
	
}
