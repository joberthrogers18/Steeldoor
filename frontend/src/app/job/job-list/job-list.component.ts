import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { JobService } from 'src/app/services/job.service';

interface Skill {
  name: string;
  code: any;
}

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.scss'],
})
export class JobListComponent implements OnInit {
  formGroupFilters!: FormGroup;
  formGroupDialog!: FormGroup;
  visibleDialogCreateJob: boolean = false;
  visibleDialogShowUsersJob: boolean = false;
  skills: Skill[] = [];
  user: any = null;
  currentUrl: string = '';
  jobs: any = [];
  auxUsers: any = [];

  constructor(
    private router: Router,
    private jobService: JobService,
    private messageService: MessageService
  ) {
    this.user = JSON.parse(String(localStorage.getItem('user_info')));
    this.currentUrl = this.router.url;
  }

  ngOnInit() {
    if (this.user.role === 'ADMIN') {
      this.jobService.getUserJobs(this.user.email).subscribe({
        next: (response: any) => {
          this.jobs = response.data;
        },
      });

      this.jobService.getAllSkills().subscribe({
        next: (response: any) => {
          {
            response.data.forEach((skill: any) => {
              this.skills.push({
                name: skill.nameSkill,
                code: skill,
              });
            });
          }
        },
      });
    }

    this.formGroupFilters = new FormGroup({
      title: new FormControl(''),
      desireSalary: new FormControl(''),
    });

    this.formGroupDialog = new FormGroup({
      companyName: new FormControl(''),
      location: new FormControl(''),
      title: new FormControl(''),
      description: new FormControl(''),
      minSalary: new FormControl(0),
      maxSalary: new FormControl(0),
      selectedSkills: new FormControl<Skill[] | null>(null),
    });
  }

  showDialogCreateJob() {
    this.visibleDialogCreateJob = true;
  }

  showDialogUsers(users: any) {
    this.auxUsers = users;
    this.visibleDialogShowUsersJob = true;
  }

  createNewJob() {
    const formData: any = this.formGroupDialog.getRawValue();
    const body: any = {
      companyName: formData.companyName,
      location: formData.location,
      title: formData.title,
      description: formData.description,
      minSalary: parseFloat(formData.minSalary),
      maxSalary: parseFloat(formData.maxSalary),
      creator: this.user.email,
      skills: formData.selectedSkills.map((skill: any) => skill.code),
    };

    this.jobService.createJob(body).subscribe({
      next: (response: any) => {
        this.formGroupDialog.reset();
        this.jobs.push(response.data);
        this.visibleDialogCreateJob = false;
      },
      error: (e: any) => {
        console.log('error login ', e);
        this.messageService.add({
          severity: 'error',
          summary: 'Error',
          detail: 'Error when try to create a job. Try again later',
        });
      },
    });
  }

  deleteJob(idJob: number) {
    this.jobService.deleteJobById(idJob).subscribe({
      next: (response: any) => {
        this.jobs = this.jobs.filter((job: any) => job.id !== idJob);
      },
      error: (e: any) => {
        console.log(e);
        this.messageService.add({
          severity: 'error',
          summary: 'Error',
          detail: 'Error when try to delete a job. Try again later',
        });
      },
    });
  }
}
