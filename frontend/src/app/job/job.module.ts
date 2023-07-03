import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JobRoutingModule } from './job-routing.module';
import { JobListComponent } from './job-list/job-list.component';
import { ButtonModule } from 'primeng/button';

@NgModule({
  declarations: [JobListComponent],
  imports: [CommonModule, JobRoutingModule, ButtonModule],
})
export class JobModule {}
