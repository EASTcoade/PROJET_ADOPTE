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
  public getByIdFetchSon(id: number): Observable<Utilisateur> {
    return this.httpClient.get<Utilisateur>(
      `${this.baseUrl}` + '/' + id + '/son'
    );
  }
  public getAllFetchAll(): Observable<Utilisateur[]> {
    return this.httpClient.get<Utilisateur[]>(this.baseUrl + '/all');
  }

  public putImage(uti_id: number, image_id: number): Observable<any> {
    return this.httpClient.post<any>(
      `${this.baseUrl}` + '/photo/' + uti_id + '/' + image_id,
      {}
    );
  }
}
