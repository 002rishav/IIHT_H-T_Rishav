import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetallsubscriptionsforuserComponent } from './getallsubscriptionsforuser.component';

describe('GetallsubscriptionsforuserComponent', () => {
  let component: GetallsubscriptionsforuserComponent;
  let fixture: ComponentFixture<GetallsubscriptionsforuserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetallsubscriptionsforuserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetallsubscriptionsforuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
