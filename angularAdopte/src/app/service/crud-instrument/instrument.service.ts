import { Instrument } from './../../model/instrument';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class InstrumentService {
  private static URL: string = 'http://localhost:8080/adopte/api/instrument';
  constructor(private httpClient: HttpClient, private router: Router) {}

  public getAll(): Observable<Instrument[]> {
    return this.httpClient.get<Instrument[]>(InstrumentService.URL);
  }
  public getAllFetchJoueurs(): Observable<Instrument[]> {
    return this.httpClient.get<Instrument[]>(
      InstrumentService.URL + '/utilisateurs'
    );
  }

  public getById(id: number): Observable<Instrument> {
    return this.httpClient.get<Instrument>(InstrumentService.URL + '/' + id);
  }

  public create(instru: Instrument): Observable<Instrument> {
    return this.httpClient.post<Instrument>(
      InstrumentService.URL,
      this.instrumentToJson(instru)
    );
  }

  public instrumentToJson(instru: Instrument): any {
    let obj = {
      id: instru.id,
      nom: instru.nom,
    };
    if (instru.image) {
      Object.assign(obj, { image: { id: instru.image.id } });
    }
    return obj;
  }
}
