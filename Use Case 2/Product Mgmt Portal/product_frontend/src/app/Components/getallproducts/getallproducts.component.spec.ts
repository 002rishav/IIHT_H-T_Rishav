import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { GetallproductsComponent } from './getallproducts.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2OrderModule } from 'ng2-order-pipe';

describe('GetallproductsComponent', () => {
  let component: GetallproductsComponent;
  let fixture: ComponentFixture<GetallproductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, ReactiveFormsModule, FormsModule, NgxPaginationModule, Ng2OrderModule],
      declarations: [ GetallproductsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetallproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
