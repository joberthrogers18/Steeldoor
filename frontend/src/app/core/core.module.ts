import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CoreRoutingModule } from './core-routing.module';
import { LoginComponent } from './login/login.component';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { CompanySignupComponent } from './company-signup/company-signup.component';
import { UserSignupComponent } from './user-signup/user-signup.component';
import { CalendarModule } from 'primeng/calendar';

@NgModule({
  declarations: [LoginComponent, CompanySignupComponent, UserSignupComponent],
  imports: [
    CommonModule,
    CoreRoutingModule,
    InputTextModule,
    ButtonModule,
    CalendarModule,
  ],
})
export class CoreModule {}
