import { Utilisateur } from './../../model/utilisateur';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class InscriptionUtiService {
  private baseUrl = 'http://localhost:8080/adopte/api/utilisateur';

  constructor(private httpClient: HttpClient) {}

  public createUtilisateur(utilisateur: Utilisateur): Observable<Utilisateur> {
    return this.httpClient.post<Utilisateur>(`${this.baseUrl}`, utilisateur);
  }

  public getAll(): Observable<Utilisateur[]> {
    return this.httpClient.get<Utilisateur[]>(`${this.baseUrl}`);
  }
}
