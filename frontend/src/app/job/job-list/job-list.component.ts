import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.scss'],
})
export class JobListComponent implements OnInit {
  formGroup!: FormGroup;

  ngOnInit() {
    this.formGroup = new FormGroup({
      title: new FormControl(''),
      desSalary: new FormControl(''),
    });
  }
}
