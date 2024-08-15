import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private apiUrl = 'http://localhost:8080/moviment';

  constructor(private http: HttpClient) { }

  getMovements(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  postMovement(payload: any): Observable<any> {
    return this.http.post(this.apiUrl, payload);
  }
}
