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
}
