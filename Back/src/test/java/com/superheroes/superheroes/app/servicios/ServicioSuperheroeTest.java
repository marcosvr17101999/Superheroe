package com.superheroes.superheroes.app.servicios;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.superheroes.superheroes.app.entity.Superheroe;
import com.superheroes.superheroes.app.repository.RepositorySuperheroe;

class ServicioSuperheroeTest {

    @Mock
    private RepositorySuperheroe repositorySuperheroe;

    @InjectMocks
    private ServicioSuperheroe ServicioSuperheroe;
    
    Superheroe heroe;

    @BeforeEach
    void setUp() {
      MockitoAnnotations.initMocks(this);
      heroe = new Superheroe();
      heroe.setNombre("Batman");
      heroe.setPoder("Dinero");
      heroe.setId(1);
    }

    @Test
    void guardarSuperhereo() {
      when(repositorySuperheroe.save(heroe)).thenReturn(heroe);
      assertNotNull(ServicioSuperheroe.guardarSuperhereo(heroe));
    }

    @Test
    void obtenerSuperheroe() {
      when(repositorySuperheroe.findById(1L)).thenReturn(java.util.Optional.of(heroe));
      assertNotNull(ServicioSuperheroe.obtenerSuperheroe(1L));
    }

    @Test
    void editarSuperheroe() {
      repositorySuperheroe.save(heroe);
      Superheroe edicionHeroe = heroe;
      edicionHeroe.setNombre("Superman");
      when(repositorySuperheroe.findById(1L)).thenReturn(java.util.Optional.of(heroe));
      assertNotEquals(edicionHeroe,ServicioSuperheroe.editarSuperheroe(1L, heroe));
    }

    @Test
    void eliminarSuperheroe() {
      when(repositorySuperheroe.findById(1L)).thenReturn(java.util.Optional.of(heroe));
      assertNotNull(ServicioSuperheroe.eliminarSuperheroe(1L));
    }

    @Test
    void findAll() {
      when(repositorySuperheroe.findAll()).thenReturn(Arrays.asList(heroe));
      assertNotNull(ServicioSuperheroe.findAll());
    }

    @Test
    void findByNombre() {
      when(repositorySuperheroe.findByNombreContainingIgnoreCase("Batman")).thenReturn(Arrays.asList(heroe));
      assertNotNull(ServicioSuperheroe.findByNombre("Batman"));
    }
}