import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { SuperheroesService } from 'src/servicios/superheroes.service';
import { superheroe } from '../listado-superheroe/superheroe';

@Component({
  selector: 'app-dialogEditar',
  templateUrl: './dialogEditar.component.html',
  styleUrls: ['./dialogEditar.component.scss'],
})
export class DialogEditarComponent implements OnInit {
  heroeNombre: string = '';
  heroePoder: string = '';
  constructor(
    public dialogo: MatDialogRef<DialogEditarComponent>,
    @Inject(MAT_DIALOG_DATA) public heroe: superheroe,
    public service: SuperheroesService
  ) {}

  ngOnInit(): void {
    this.heroeNombre = this.heroe.nombre;
    this.heroePoder = this.heroe.poder;
  }

  guardar() {
    const heroeModificado: superheroe = new superheroe();
    heroeModificado.id = this.heroe.id;
    heroeModificado.nombre = this.heroeNombre;
    heroeModificado.poder = this.heroePoder;
    this.service.update(this.heroe.id, heroeModificado);
  }
  cerrarDialogo(): void {
    this.dialogo.close(false);
  }

  confirmado(): void {
    this.dialogo.close(true);
  }
}
