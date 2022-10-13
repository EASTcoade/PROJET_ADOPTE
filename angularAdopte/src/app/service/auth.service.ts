import { Utilisateur } from './../model/utilisateur';
import { Compte } from '../model/compte';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
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
      'http://localhost:8080/adopte/api/auth/utilisateur',
      {
        headers: monHeader,
      }
    );
  }

  public register(form: any): Observable<any> {
    console.log(form);
    return this.httpClient.post<any>(
      'http://localhost:8080/adopte/api/utilisateur',
      form
    );
  }

  public isAuthenticated(): boolean {
    return sessionStorage.getItem('token') ? true : false;
  }
  public logout() {
    sessionStorage.removeItem('token');
    sessionStorage.removeItem('compte');
    sessionStorage.removeItem('role');
    this.router.navigateByUrl('/connexion');
  }
}
