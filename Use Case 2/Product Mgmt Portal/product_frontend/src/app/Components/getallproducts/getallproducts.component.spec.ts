import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { GetallproductsComponent } from './getallproducts.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

describe('GetallproductsComponent', () => {
  let component: GetallproductsComponent;
  let fixture: ComponentFixture<GetallproductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, ReactiveFormsModule, FormsModule],
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
