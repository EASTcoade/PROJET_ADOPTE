import { Utilisateur } from 'src/app/model/utilisateur';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UtilisateurService {
  private baseUrl = 'http://localhost:8080/adopte/api/utilisateur';

  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Utilisateur[]> {
    return this.httpClient.get<Utilisateur[]>(`${this.baseUrl}`);
  }

  public getByIdFetchAll(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(`${this.baseUrl}` + '/' + id);
  }
}
