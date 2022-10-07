import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from 'src/app/model/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class InscriptionUtiService {

  private baseUrl =  "http://localhost:8080/adopte/api/utilisateur";

  constructor(private httpClient: HttpClient) { }

  createUtilisateur(utilisateur: Utilisateur): Observable<Utilisateur>{
    return this.httpClient.post<Utilisateur>(`${this.baseUrl}`, utilisateur );

  }

}
