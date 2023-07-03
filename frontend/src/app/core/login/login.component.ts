import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  formGroup!: FormGroup;

  constructor(private jobService: JobService, private router: Router) {}

  ngOnInit() {
    this.formGroup = new FormGroup({
      email: new FormControl<string>(''),
      password: new FormControl<string>(''),
    });
  }

  handleLogin() {
    const formData: any = this.formGroup.getRawValue();
    this.jobService
      .loginUser({
        email: formData.email,
        password: formData.password,
      })
      .subscribe({
        next: (response: any) => {
          this.router.navigateByUrl('/list');
        },
        error: (e: any) => {
          console.log('error login ', e);
        },
      });
  }
}
