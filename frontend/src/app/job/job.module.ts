import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JobRoutingModule } from './job-routing.module';
import { JobListComponent } from './job-list/job-list.component';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { InputNumberModule } from 'primeng/inputnumber';
import { DialogModule } from 'primeng/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MultiSelectModule } from 'primeng/multiselect';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';
import { UtilService } from '../services/utils.service';
import { JobService } from '../services/job.service';

@NgModule({
  declarations: [JobListComponent],
  imports: [
    CommonModule,
    JobRoutingModule,
    ButtonModule,
    InputTextModule,
    InputNumberModule,
    DialogModule,
    FormsModule,
    ReactiveFormsModule,
    MultiSelectModule,
    ToastModule,
  ],
  providers: [MessageService, UtilService, JobService],
})
export class JobModule {}
