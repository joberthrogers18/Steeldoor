import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class JobService {
  constructor(private http: HttpClient) {}

  createCompany(body: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/api/company`, body);
  }

  createUser(body: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/api/user`, body);
  }
}
