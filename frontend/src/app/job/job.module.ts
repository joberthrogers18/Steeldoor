import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JobRoutingModule } from './job-routing.module';
import { JobListComponent } from './job-list/job-list.component';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';

@NgModule({
  declarations: [JobListComponent],
  imports: [
    CommonModule,
    JobRoutingModule,
    ButtonModule,
    InputTextModule,
    InputNumberModule,
  ],
})
export class JobModule {}
