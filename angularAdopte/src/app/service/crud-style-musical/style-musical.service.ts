import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { StyleMusical } from 'src/app/model/style-musical';
@Injectable({
  providedIn: 'root',
})
export class StyleMusicalService {
  private static URL: string = 'http://localhost:8080/adopte/api/style';
  constructor(private httpClient: HttpClient, private router: Router) {}

  public getAll(): Observable<StyleMusical[]> {
    return this.httpClient.get<StyleMusical[]>(StyleMusicalService.URL);
  }

  public getById(id: number): Observable<StyleMusical> {
    return this.httpClient.get<StyleMusical>(
      StyleMusicalService.URL + '/' + id
    );
  }
  public create(style: StyleMusical): Observable<StyleMusical> {
    return this.httpClient.post<StyleMusical>(
      StyleMusicalService.URL,
      this.styleMusicalToJson(style)
    );
  }

  public styleMusicalToJson(style: StyleMusical): any {
    let obj = {
      id: style.id,
      nom: style.nom,
    };
    return obj;
  }
}
