import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { JobService } from 'src/app/services/job.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  formGroup!: FormGroup;

  constructor(
    private jobService: JobService,
    private router: Router,
    private messageService: MessageService
  ) {}

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
          localStorage.setItem('user_info', JSON.stringify(response.data));
          if (response.data.role === 'ADMIN') {
            this.router.navigateByUrl('/job/admin');
          } else {
            this.router.navigateByUrl('/job/list');
          }
        },
        error: (e: any) => {
          console.log('error login ', e);
          this.messageService.add({
            severity: 'error',
            summary: 'Error',
            detail: 'Error when try to login. Try again later',
          });
        },
      });
  }
}
