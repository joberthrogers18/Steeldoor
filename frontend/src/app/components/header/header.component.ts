import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  userData: any;

  constructor() {
    this.userData = JSON.parse(String(localStorage.getItem('user_info')));
    console.log(this.userData.role);
  }
}
