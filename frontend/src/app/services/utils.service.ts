import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UtilService {
  formatDate(date: Date): string {
    return `${date.getFullYear()}-${
      date.getMonth() + 1 < 10
        ? '0' + String(date.getMonth() + 1)
        : date.getMonth() + 1
    }-${date.getDate() < 10 ? '0' + String(date.getDate()) : date.getDate()}`;
  }
}
