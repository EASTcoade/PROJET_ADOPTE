import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Image } from 'src/app/model/image';

@Injectable({
  providedIn: 'root',
})
export class ImageService {
  private static URL = 'http://localhost:8080/adopte/api/image';

  constructor(private httpClient: HttpClient) {}

  public getById(id: number): Observable<Image> {
    return this.httpClient.get<Image>(`${ImageService.URL}/${id}`);
  }
  public getByIdToRead(id: number): Observable<any> {
    return this.httpClient.get<Image>(`${ImageService.URL}/${id}/` + 'read');
  }
  public create(image: FormData): Observable<Image> {
    return this.httpClient.post<Image>(ImageService.URL, image);
  }
}
