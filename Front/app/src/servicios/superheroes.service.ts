import { Injectable } from '@angular/core';
import data from '../app/listado-superheroe/listadoHeroes.json';
import { superheroe } from '../app/listado-superheroe/superheroe';
@Injectable({
  providedIn: 'root',
})
export class SuperheroesService {
  constructor() {}

  heroes: superheroe = new superheroe();

  getAll() {
    return data;
  }

  getById(id: number) {
    return data.find((x) => x.id === id);
  }

  update(id: number, params: any) {
    const heroe: superheroe = this.getById(id)!;
    Object.assign(heroe, params);
  }

  delete(id: number) {
    const heroe: superheroe = this.getById(id)!;
    data.splice(data.indexOf(heroe), 1);
  }

  findByNombre(nombre: string) {
    return data.find((x) => x.nombre == nombre)!;
  }

  create(nombre: string, poder: string) {
    const heroe: superheroe = new superheroe();
    const obj = {
      id: data.length + 1,
      nombre: nombre,
      poder: poder,
    };
    data.push(obj);
    console.log(data);
  }

  findByFilter(nombre: string) {
    const results: { id: number; nombre: string; poder: string }[] = [];
    data.forEach((element) => {
      if (element.nombre.toLowerCase().includes(nombre.toLowerCase())) {
        results.push(element);
      }
    });
    return results;
  }
}
