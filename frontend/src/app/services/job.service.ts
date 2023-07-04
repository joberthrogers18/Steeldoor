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

  loginUser(body: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/api/user/login`, body);
  }

  getUserJobs(email: String): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/job/user/${email}`);
  }

  getAllSkills(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/skills`);
  }

  createJob(body: any): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/api/job`, body);
  }

  deleteJobById(id: number): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/job/${id}`);
  }

  getAllJobs(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/jobs`);
  }

  getAppliedJobs(id: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/user/${id}/jobs`);
  }
  updateJob(id: number, body: any): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/api/job/${id}`, body);
  }
}
