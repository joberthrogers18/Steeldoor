import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
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
  skills!: Skill[];
  user: any = null;
  currentUrl: string = '';
  jobs: any = [];

  constructor(private router: Router, private jobService: JobService) {
    this.user = JSON.parse(String(localStorage.getItem('user_info')));
    this.currentUrl = this.router.url;
  }

  ngOnInit() {
    if (this.user.role === 'ADMIN') {
      this.jobService.getUserJobs(this.user.email).subscribe({
        next: (response: any) => {
          this.jobs = response.data;
          console.log(response);
        },
      });
    }

    this.formGroupFilters = new FormGroup({
      title: new FormControl(''),
      desireSalary: new FormControl(''),
    });

    this.skills = [
      {
        name: 'Java',
        code: {
          id: 1,
          nameSkill: 'Java',
        },
      },
      {
        name: 'C',
        code: {
          id: 2,
          nameSkill: 'C',
        },
      },
      {
        name: 'Javascript',
        code: {
          id: 3,
          nameSkill: 'Javascript',
        },
      },
    ];

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

  showDialogUsers() {
    this.visibleDialogShowUsersJob = true;
  }
}
