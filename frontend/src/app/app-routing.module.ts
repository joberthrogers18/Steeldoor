import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoreRoutingModule } from './core/core-routing.module';
import { JobModule } from './job/job.module';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => CoreRoutingModule,
  },
  {
    path: 'job',
    loadChildren: () => JobModule,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
