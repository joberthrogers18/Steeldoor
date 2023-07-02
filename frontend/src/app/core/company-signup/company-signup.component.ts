import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-company-signup',
  templateUrl: './company-signup.component.html',
  styleUrls: ['./company-signup.component.scss'],
})
export class CompanySignupComponent implements OnInit {
  formGroup: FormGroup | undefined;

  ngOnInit() {
    this.formGroup = new FormGroup({
      companyName: new FormControl<string>(''),
      address: new FormControl<string>(''),
      firstName: new FormControl<string>(''),
      lastName: new FormControl<string>(''),
      birthday: new FormControl<string>(''),
      phone: new FormControl<string>(''),
      email: new FormControl<string>(''),
      password: new FormControl<string>(''),
    });
  }
}
