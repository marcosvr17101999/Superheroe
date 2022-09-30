import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { DialogEditarComponent } from '../dialogEditar/dialogEditar.component';
import { SuperheroesService } from './../../servicios/superheroes.service';
import { superheroe } from './superheroe';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-listado-superheroe',
  templateUrl: './listado-superheroe.component.html',
  styleUrls: ['./listado-superheroe.component.scss']
})
export class ListadoSuperheroeComponent implements OnInit,AfterViewInit {
  aniadir = false;
  heroeNombre: string = '';
  busqueda: string = '';

  heroePoder: string = '';
  columns = [{ prop: 'id' }, { name: 'nombre' }, { name: 'poder' },{ name: 'acciones' }];
  dat2:superheroe[] = [];
  dataSource = new MatTableDataSource<superheroe>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  constructor(private service :SuperheroesService,public dialog : MatDialog) {

   }
  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }


  displayedColumns: string[] = ['id', 'nombre', 'poder','acciones'];
  heroes: superheroe[] | undefined;

  ngOnInit(): void {
    this.dataSource.data =this.service.getAll();
    console.log(this.dataSource);
    console.log(this.service.findByFilter("man"));

  }

  abrirDialogo(superheroe:superheroe) {
    this.dialog
      .open(DialogEditarComponent, {
        data: superheroe,
      })
  }

  eliminar(id: number) {
    if(confirm("Estas seguro de eliminar el superheroe? ")) {
      this.service.delete(id)
      console.log(this.dataSource);
      this.dataSource.data=this.service.getAll();
    }

  }
  formularioAniadir(){
    this.aniadir = true;
  }
  onSubmit(){
    this.service.create(this.heroeNombre,this.heroePoder);

    this.dataSource.data=this.service.getAll();
    this.aniadir = false;
  }

  onSearch(texto:string){
    this.dataSource.data=this.service.findByFilter(texto);
  }

}
