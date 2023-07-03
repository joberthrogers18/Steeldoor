import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { JobService } from 'src/app/services/job.service';
import { UtilService } from 'src/app/services/utils.service';

@Component({
  selector: 'app-company-signup',
  templateUrl: './company-signup.component.html',
  styleUrls: ['./company-signup.component.scss'],
})
export class CompanySignupComponent implements OnInit {
  formGroup!: FormGroup;
  disableBtn: boolean = false;

  constructor(
    private jobService: JobService,
    private utilService: UtilService,
    private messageService: MessageService,
    private router: Router
  ) {}

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

  onHandleSignUp() {
    const formData: any = this.formGroup.getRawValue();

    this.jobService
      .createCompany({
        name: formData.companyName,
        address: formData.address,
      })
      .subscribe({
        next: (data: any) => {
          this.jobService
            .createUser({
              firstName: formData.firstName,
              lastName: formData.lastName,
              phone: formData.phone,
              email: formData.email,
              password: formData.password,
              birthday: this.utilService.formatDate(formData.birthday),
              role: 'ADMIN',
              company: data.company,
            })
            .subscribe({
              next: (data: any) => {
                localStorage.setItem('user_info', JSON.stringify(data.data));
                this.router.navigateByUrl('/');
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
