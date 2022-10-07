import { Observable } from 'rxjs';
import { Son } from './../../model/son';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SonService {
  private static URL = 'http://localhost:8080/adopte/api/son';
  constructor(private httpClient: HttpClient) {}

  public getAll(): Observable<Son[]> {
    return this.httpClient.get<Son[]>(SonService.URL);
  }

  public delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(SonService.URL);
  }

  public getById(id: number): Observable<Son> {
    return this.httpClient.get<Son>(`${SonService.URL}/${id}`);
  }

  public create(son: Son): Observable<Son> {
    return this.httpClient.post<Son>(SonService.URL, this.sonToJson(son));
  }

  public sonToJson(son: Son): any {
    let obj = {
      id: son.id,
      titre: son.titre,
      contenu: son.contenu,
      createur: { id: son.createur?.id },
    };
    if (son.createur) {
      Object.assign(obj, { Utilisateur: { id: son.createur?.id } });
      return obj;
    }
  }
}
