import { Component } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  items: MenuItem[] | undefined = [];
  showHeader: boolean = false;

  constructor(private router: Router) {
    const notAllowHeaderPath: string[] = [
      '/',
      '/sign-up-company',
      '/sign-up-user',
    ];

    router.events.subscribe((val) => {
      if (val instanceof NavigationEnd) {
        this.showHeader = notAllowHeaderPath.some((currentUrl: string) => {
          return currentUrl === val.url;
        });
      }
    });
  }
}
