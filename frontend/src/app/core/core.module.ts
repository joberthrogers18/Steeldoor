import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoreRoutingModule } from './core-routing.module';
import { LoginComponent } from './login/login.component';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CompanySignupComponent } from './company-signup/company-signup.component';
import { UserSignupComponent } from './user-signup/user-signup.component';
import { CalendarModule } from 'primeng/calendar';
import { ReactiveFormsModule } from '@angular/forms';
import { PasswordModule } from 'primeng/password';
import { JobService } from '../services/job.service';
import { UtilService } from '../services/utils.service';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

@NgModule({
  declarations: [LoginComponent, CompanySignupComponent, UserSignupComponent],
  imports: [
    CommonModule,
    CoreRoutingModule,
    InputTextModule,
    ButtonModule,
    CalendarModule,
    ReactiveFormsModule,
    PasswordModule,
    ToastModule,
  ],
  providers: [JobService, UtilService, MessageService],
})
export class CoreModule {}
