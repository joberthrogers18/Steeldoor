import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { JobService } from 'src/app/services/job.service';
import { UtilService } from 'src/app/services/utils.service';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.scss'],
})
export class UserSignupComponent implements OnInit {
  formGroup!: FormGroup;

  constructor(
    private utilService: UtilService,
    private router: Router,
    private messageService: MessageService,
    private jobService: JobService
  ) {}

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

  onHandleSignUp() {
    const formData: any = this.formGroup.getRawValue();

    this.jobService
      .createUser({
        firstName: formData.firstName,
        lastName: formData.lastName,
        phone: formData.phone,
        email: formData.email,
        password: formData.password,
        birthday: this.utilService.formatDate(formData.birthday),
        role: 'SEEKER',
      })
      .subscribe({
        next: (data: any) => {
          localStorage.setItem('user_info', JSON.stringify(data.data));
          this.router.navigateByUrl('/job/list');
        },
        error: (e: any) => {
          console.log('Error to signup user', e);
          this.messageService.add({
            severity: 'error',
            summary: 'Error',
            detail: 'Error when try to sign up. Try again later',
          });
        },
      });
  }
}
