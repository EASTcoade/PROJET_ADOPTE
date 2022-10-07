import { Compte } from '../model/compte';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthAdminService {
  constructor(private router: Router, private httpClient: HttpClient) {}

  public authentification(
    username: string,
    password: string
  ): Observable<Compte> {
    let monHeader = new HttpHeaders({
      Authorization: 'Basic ' + btoa(`${username}:${password}`),
      // Buffer.from(`${username}:${password}`).toString('base64'),
    });
    return this.httpClient.get<Compte>(
      'http://localhost:8080/adopte/api/auth/admin',
      {
        headers: monHeader,
      }
    );
  }

  public isAuthenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }
  public logout() {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('compte');
    this.router.navigateByUrl('/connexion');
  }
}
