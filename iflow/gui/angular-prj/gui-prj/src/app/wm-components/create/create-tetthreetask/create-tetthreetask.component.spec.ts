import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTetthreetaskComponent } from './create-tetthreetask.component';

describe('CreateTetthreetaskComponent', () => {
  let component: CreateTetthreetaskComponent;
  let fixture: ComponentFixture<CreateTetthreetaskComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateTetthreetaskComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTetthreetaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
