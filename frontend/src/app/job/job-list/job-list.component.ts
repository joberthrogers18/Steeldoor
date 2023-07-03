import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

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
  visible: boolean = true;
  skills!: Skill[];

  ngOnInit() {
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

  showDialog() {
    this.visible = true;
  }
}
