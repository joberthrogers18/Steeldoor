import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanySignupComponent } from './company-signup/company-signup.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
  },
  {
    path: 'sign-up-company',
    component: CompanySignupComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CoreRoutingModule {}
