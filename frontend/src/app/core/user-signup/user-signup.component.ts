import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.scss'],
})
export class UserSignupComponent implements OnInit {
  formGroup: FormGroup | undefined;

  ngOnInit() {
    this.formGroup = new FormGroup({
      firstName: new FormControl<string>(''),
      lastName: new FormControl<string>(''),
      birthday: new FormControl<string>(''),
      phone: new FormControl<string>(''),
      email: new FormControl<string>(''),
      password: new FormControl<string>(''),
    });
  }
}
