import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class JobService {
  baseUrl: string = 'http://localhost:8080/api';
  constructor(private http: HttpClient) {}

  createCompany(body: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/company`, body);
  }

  createUser(body: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/user`, body);
  }

  loginUser(body: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/user/login`, body);
  }

  getUserJobs(email: String): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/job/user/${email}`);
  }

  getAllSkills(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/skills`);
  }

  createJob(body: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/job`, body);
  }

  deleteJobById(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/job/${id}`);
  }

  getAllJobs(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/jobs`);
  }

  getAppliedJobs(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/user/${id}/jobs`);
  }
  updateJob(id: number, body: any): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/job/${id}`, body);
  }
}
