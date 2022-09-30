import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoSuperheroeComponent } from './listado-superheroe.component';

describe('ListadoSuperheroeComponent', () => {
  let component: ListadoSuperheroeComponent;
  let fixture: ComponentFixture<ListadoSuperheroeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListadoSuperheroeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListadoSuperheroeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
